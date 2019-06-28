package ir.sharif.vamdeh.activity.before_main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.LoginEvent
import ir.sharif.vamdeh.task.jobs.LoginJob
import kotlinx.android.synthetic.main.activity_login.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick

class LoginActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        submit.setOnClickListener {
            scheduleJob(LoginJob.TAG, getPasswordExtras(password.text.toString()))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LoginEvent) : Any = if (event.successful) gotoMainPage() else toastLoginFailed()

}
