package ir.sharif.vamdeh.activity.before_main

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.helper.getPasswordExtras
import ir.sharif.vamdeh.helper.gotoMainPage
import ir.sharif.vamdeh.helper.scheduleJob
import ir.sharif.vamdeh.helper.toastInvalidPassword
import ir.sharif.vamdeh.task.events.RegisterEvent
import ir.sharif.vamdeh.task.jobs.RegisterJob
import kotlinx.android.synthetic.main.activity_register.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick
class RegisterActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        register.onClick { register(password1.text.toString(), password2.text.toString()) }
    }

    private fun register(pass1: String, pass2: String){
        if(pass1 == pass2) scheduleJob(RegisterJob.TAG, getPasswordExtras(pass1))
        else toastInvalidPassword()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: RegisterEvent) {
        defaultCache()[CacheConstants.KEY_IS_REGISTER] = true
        defaultCache()[CacheConstants.KEY_PASSWORD] = event.password
        gotoMainPage()
    }

}

