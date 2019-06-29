package ir.sharif.vamdeh.activity.before_main

import android.os.Bundle
import android.view.View
import com.github.ybq.android.spinkit.style.CubeGrid
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.VerificationErrorEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.task.jobs.VerificationJob
import ir.sharif.vamdeh.utils.*
import kotlinx.android.synthetic.main.activity_phone.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

const val MAX_PHONE_LENGTH = 11

class PhoneActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        decideToOpenApplication()
        submit.setOnClickListener { login(phoneNumber.text.toString()) }

        phoneNumber.addOnTextChangedListener { text ->
            if(text.length >= MAX_PHONE_LENGTH) hideKeyboard() else showKeyboard()
        }
    }

    private fun decideToOpenApplication() {
        val isRegister: Boolean = defaultCache()[CacheConstants.KEY_IS_REGISTER] ?: false
        val phoneNumber: String? = defaultCache()[CacheConstants.KEY_PHONE]
        val code: String? = defaultCache()[CacheConstants.KEY_CODE]

        val hasPhone = !phoneNumber.isNullOrEmpty()
        val hasCode = !code.isNullOrEmpty()

        if (isRegister && hasPhone) gotoLoginPage()
        else if (hasPhone && hasCode) gotoRegister()
    }

    private fun login(phone: String) {
        if (isValidPhone(phone)) {
            showLoading()
            scheduleJob(VerificationJob.TAG, getPhoneExtras(phone))
        } else toastError(getString(R.string.phone_number_error))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: VerificationEvent) = hideLoading().also {
        if (event.registeredUser) gotoLoginPage() else gotoActivation(event.phone)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: VerificationErrorEvent) = hideLoading().also { toastError(event.error) }

    private fun showLoading() { spinKit.visibility = View.VISIBLE }

    private fun hideLoading() { spinKit.visibility = View.GONE }
}

