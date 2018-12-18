package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.SendVerificationCodeEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class SendVerificationCodeJob : Job() {

    companion object { const val TAG = "send_verification_code_tag" }

    override fun onRunJob(params: Params): Result {
        val phone = params.extras.getString(JobConstants.PHONE_NUMBER, "")
        val code = params.extras.getString(JobConstants.VERIFICATION_CODE, "")
        WebserviceHelper.sendVerificationCode(phone, code)
        EventBus.getDefault().post(SendVerificationCodeEvent(phone))
        return Result.SUCCESS
    }

}