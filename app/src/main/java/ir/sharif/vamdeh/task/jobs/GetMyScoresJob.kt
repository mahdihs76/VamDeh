package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import ir.sharif.vamdeh.enum.RateType
import ir.sharif.vamdeh.model.RateModel
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class GetMyScoresJob : Job() {

    companion object { const val TAG = "get_my_scores_tag" }

    override fun onRunJob(params: Params): Result {
        val map = RateType.values().associateBy(RateType::sType);
        val response = WebserviceHelper.getMyScores()
        val rateModel = RateModel(0, 0, 0)
        response.forEach {
            when (map[it.sType]) {
                RateType.TOTAL_RATE -> rateModel.totalRate = it.value
                RateType.SWEAT_HEART_RATE -> rateModel.sweatHeartRate = it.value
                RateType.LOAN_RATE -> rateModel.loanRate = it.value
            }
        }
        EventBus.getDefault().post(GetMyScoresEvent(rateModel))
        return Result.SUCCESS
    }

}