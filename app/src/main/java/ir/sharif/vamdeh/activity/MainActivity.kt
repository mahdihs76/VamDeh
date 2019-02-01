package ir.sharif.vamdeh.activity

import android.os.Bundle
import android.util.Log
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.enum.MenuItem
import ir.sharif.vamdeh.helper.gotoPhonePage
import ir.sharif.vamdeh.helper.gotoProfile
import ir.sharif.vamdeh.helper.scheduleJob
import ir.sharif.vamdeh.helper.toastLoginFailed
import ir.sharif.vamdeh.model.RateModel
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.LoginEvent
import ir.sharif.vamdeh.task.jobs.GetMyScoresJob
import ir.sharif.vamdeh.task.jobs.LoginJob
import ir.sharif.vamdeh.utils.generateCircularItem
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick


class MainActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        login()
        initCircularMenu()
        profileImage.onClick { gotoProfile() }
        Log.e("TAG", WebservicePrefSetting.getInstance(this).token)
    }

    private fun login() = scheduleJob(LoginJob.TAG)

    private fun getMyScores() = scheduleJob(GetMyScoresJob.TAG)

    private fun initCircularMenu() =
            enumValues<MenuItem>().forEach { circularLayout.addView(generateCircularItem(this, it)) }

    private fun updateData(rateModel: RateModel) {
        totalRate.text = rateModel.totalRate.toString()
        sweatHeartRate.text = rateModel.sweatHeartRate.toString()
        loanRate.text = rateModel.loanRate.toString()
    }

    private fun loginFailed(){
        defaultCache()[CacheConstants.KEY_IS_REGISTER] = false
        defaultCache()[CacheConstants.KEY_PHONE] = null
        toastLoginFailed()
        gotoPhonePage()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: LoginEvent) : Any = if (event.successful) getMyScores() else loginFailed()

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: GetMyScoresEvent) = updateData(event.rateModel)

}
