package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class GetMyScoresJob : Job() {

    override fun onRunJob(params: Params): Result {

        val response = WebserviceHelper.getMyScores()
        EventBus.getDefault().post(GetMyScoresEvent(response.totalRate, response.sweatHeartRate, response.loanRate))
        return Result.SUCCESS
    }

    companion object {
        fun scheduleJob() {
            JobRequest.Builder(JobConstants.GET_MY_SCORES_TAG)
                    .startNow()
                    .build()
                    .schedule()
        }
    }

}