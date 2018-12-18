package ir.sharif.vamdeh.activity.before_main

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.SendVerificationCodeEvent
import ir.sharif.vamdeh.task.jobs.SendVerificationCodeJob
import ir.sharif.vamdeh.utils.getInLineEditTexts
import ir.sharif.vamdeh.utils.handleInLineEditTextFocus
import kotlinx.android.synthetic.main.activity_activation.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick

class ActivationActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activation)
        val vCodeEditTexts = arrayOf(digit1, digit2, digit3, digit4)
        val phone = intent.getStringExtra(KEY_PHONE) ?: ""

        handleInLineEditTextFocus(1, vCodeEditTexts)
        submit.onClick { activateUser(phone, getInLineEditTexts(vCodeEditTexts)) }
    }

    private fun activateUser(phone: String, code: String) =
            scheduleJob(SendVerificationCodeJob.TAG, getPhoneAndCodeExtras(phone, code))

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: SendVerificationCodeEvent) {
        defaultCache()[CacheConstants.KEY_PHONE] = event.phone
        gotoRegister()
    }

}
