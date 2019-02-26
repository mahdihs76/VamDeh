package ir.sharif.vamdeh.activity.before_main

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.task.jobs.VerificationJob
import ir.sharif.vamdeh.utils.isValidPhone
import kotlinx.android.synthetic.main.activity_phone.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick

class PhoneActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        decideToOpenApplication()
        submit.onClick { login(phoneNumber.text.toString()) }
    }

    private fun decideToOpenApplication() {
        val isRegister: Boolean = defaultCache()[CacheConstants.KEY_IS_REGISTER] ?: false
        val phoneNumber: String? = defaultCache()[CacheConstants.KEY_PHONE]

        val hasPhone = !phoneNumber.isNullOrEmpty()

        if (isRegister && hasPhone) gotoMainPage()
        else if (hasPhone) gotoRegister()
    }

    private fun login(phone: String) {
        if (isValidPhone(phone)) {
            gotoActivation(phone)
//            scheduleJob(VerificationJob.TAG, getPhoneExtras(phone))
        } else {
            toastInvalidPhone()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: VerificationEvent) = gotoActivation(event.phone)

}