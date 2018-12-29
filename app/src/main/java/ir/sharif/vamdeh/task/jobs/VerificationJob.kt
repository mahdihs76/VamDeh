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

    companion object { const val TAG = "verification_tag" }

    override fun onRunJob(params: Params): Result {
        val phone = normalizePhone(params.extras.getString(JobConstants.PHONE_NUMBER, ""))
        WebserviceHelper.verification(phone)
        EventBus.getDefault().post(VerificationEvent(phone))
        return Result.SUCCESS
    }

}
