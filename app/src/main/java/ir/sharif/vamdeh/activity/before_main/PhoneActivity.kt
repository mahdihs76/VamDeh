package ir.sharif.vamdeh.activity.before_main

import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import com.github.ybq.android.spinkit.style.CubeGrid
import com.irozon.sneaker.Sneaker
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.VerificationErrorEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.task.jobs.VerificationJob
import ir.sharif.vamdeh.utils.getAppTypeface
import ir.sharif.vamdeh.utils.isValidPhone
import kotlinx.android.synthetic.main.activity_phone.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class PhoneActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        spinKit.setIndeterminateDrawable(CubeGrid())
        decideToOpenApplication()
        submit.setOnClickListener { login(phoneNumber.text.toString()) }
    }

    private fun decideToOpenApplication() {
        val isRegister: Boolean = defaultCache()[CacheConstants.KEY_IS_REGISTER] ?: false
        val phoneNumber: String? = defaultCache()[CacheConstants.KEY_PHONE]

        val hasPhone = !phoneNumber.isNullOrEmpty()

        if (isRegister && hasPhone) gotoLoginPage()
        else if (hasPhone) gotoRegister()
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

    private fun showLoading() {
        spinKit.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        spinKit.visibility = View.GONE
    }
}

