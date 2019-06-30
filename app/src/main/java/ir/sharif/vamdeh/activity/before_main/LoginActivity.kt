package ir.sharif.vamdeh.activity.before_main

import android.os.Bundle
import android.view.View
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.getPasswordExtras
import ir.sharif.vamdeh.helper.gotoMainPage
import ir.sharif.vamdeh.helper.scheduleJob
import ir.sharif.vamdeh.helper.toastError
import ir.sharif.vamdeh.task.events.LoginEvent
import ir.sharif.vamdeh.task.jobs.LoginJob
import kotlinx.android.synthetic.main.activity_login.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class LoginActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        submit.setOnClickListener {
            showLoading()
            scheduleJob(LoginJob.TAG, getPasswordExtras(password.text.toString()))
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LoginEvent) = hideLoading().apply {
        if (event.successful) gotoMainPage() else toastError(getString(R.string.login_error))
    }

    private fun showLoading() { spinKit.visibility = View.VISIBLE }

    private fun hideLoading() { spinKit.visibility = View.GONE }
}
