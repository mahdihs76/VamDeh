package ir.sharif.vamdeh.activity

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.helper.gotoActivation
import ir.sharif.vamdeh.helper.toastInvalidPhone
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.utils.isValidPhone
import kotlinx.android.synthetic.main.activity_phone.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick

class PhoneActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        submit.onClick { login(phoneNumber.text.toString()) }
    }

    private fun login(phone: String) {
        if (isValidPhone(phone)) {
//            VerificationJob.scheduleJob(phone)
            gotoActivation(phone)
        } else {
            toastInvalidPhone()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: VerificationEvent) = gotoActivation()

}