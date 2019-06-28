package ir.sharif.vamdeh.activity

import android.os.Bundle
import android.util.Log
import com.ramotion.circlemenu.CircleMenuView
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.helper.gotoPhonePage
import ir.sharif.vamdeh.helper.gotoProfile
import ir.sharif.vamdeh.helper.scheduleJob
import ir.sharif.vamdeh.helper.toastLoginFailed
import ir.sharif.vamdeh.model.RateModel
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.LoginEvent
import ir.sharif.vamdeh.task.jobs.GetMyScoresJob
import ir.sharif.vamdeh.task.jobs.LoginJob
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick
import ir.sharif.vamdeh.enum.getMenuItem
import ir.sharif.vamdeh.utils.action


class MainActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initCircularMenu()
        profileImage.setOnClickListener { gotoProfile() }
    }

    private fun getMyScores() = scheduleJob(GetMyScoresJob.TAG)

    private fun initCircularMenu(){
        circularLayout.eventListener = object : CircleMenuView.EventListener(){
            override fun onButtonClickAnimationEnd(view: CircleMenuView, buttonIndex: Int) {
                super.onButtonClickAnimationEnd(view, buttonIndex)
                getMenuItem(buttonIndex).action(this@MainActivity)
            }

        }
    }

    private fun updateData(rateModel: RateModel) {
        totalRate.text = rateModel.totalRate.toString()
        sweatHeartRate.text = rateModel.sweatHeartRate.toString()
        loanRate.text = rateModel.loanRate.toString()
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: GetMyScoresEvent) = updateData(event.rateModel)

}
