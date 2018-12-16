package ir.sharif.vamdeh.activity

import android.os.Bundle
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.enum.MenuItem
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.model.RateModel
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.task.jobs.GetMyScoresJob
import ir.sharif.vamdeh.utils.generateCircularItem
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.sdk27.coroutines.onClick


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMyScores()
        initCircularMenu()
        profileImage.onClick { gotoProfile() }
    }

    private fun getMyScores() = GetMyScoresJob.scheduleJob()

    private fun initCircularMenu() =
            enumValues<MenuItem>().forEach { circularLayout.addView(generateCircularItem(it)) }

    private fun updateData(rateModel: RateModel) {
        totalRate.text = rateModel.totalRate.toString()
        sweatHeartRate.text = rateModel.sweatHeartRate.toString()
        loanRate.text = rateModel.loanRate.toString()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: GetMyScoresEvent) = updateData(RateModel(event.totalRate, event.sweatHeartRate, event.loanRate))

}
