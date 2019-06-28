package ir.sharif.vamdeh.activity.before_main

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.SendVerificationErrorEvent
import ir.sharif.vamdeh.task.events.SendVerificationEvent
import ir.sharif.vamdeh.task.jobs.SendVerificationJob
import ir.sharif.vamdeh.utils.getInLineEditTexts
import ir.sharif.vamdeh.utils.handleInLineEditTextFocus
import kotlinx.android.synthetic.main.activity_activation.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class ActivationActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activation)
        val vCodeEditTexts = arrayOf(digit1, digit2, digit3, digit4)
        val phone = intent.getStringExtra(KEY_PHONE) ?: ""

        handleInLineEditTextFocus(1, vCodeEditTexts)
        submit.setOnClickListener { activateUser(phone, getInLineEditTexts(vCodeEditTexts)) }
    }

    private fun activateUser(phone: String, code: String) {
        scheduleJob(SendVerificationJob.TAG, getPhoneAndCodeExtras(phone, code))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: SendVerificationEvent) {
            defaultCache()[CacheConstants.KEY_PHONE] = event.phone
            defaultCache()[CacheConstants.KEY_CODE] = event.code
            gotoRegister()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: SendVerificationErrorEvent) = toast(event.error)

}
