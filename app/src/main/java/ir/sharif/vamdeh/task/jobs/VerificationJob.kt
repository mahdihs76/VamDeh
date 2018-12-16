package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.utils.normalizePhone
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class VerificationJob : Job() {

    override fun onRunJob(params: Params): Result {

        val phone = params.extras.getString(JobConstants.PHONE_NUMBER, "")
        val response = WebserviceHelper.verification(normalizePhone(phone))
        EventBus.getDefault().post(VerificationEvent())
        return Result.SUCCESS
    }

    companion object {
        fun scheduleJob(phone: String) {
            val extras = PersistableBundleCompat().apply { putString(JobConstants.PHONE_NUMBER, phone) }
            JobRequest.Builder(JobConstants.VERIFICATION_TAG)
                    .addExtras(extras)
                    .startNow()
                    .build()
                    .schedule()
        }
    }

}
