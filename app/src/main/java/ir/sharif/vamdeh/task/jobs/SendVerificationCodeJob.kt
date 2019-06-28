package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.SendVerificationCodeErrorEvent
import ir.sharif.vamdeh.task.events.SendVerificationCodeEvent
import ir.sharif.vamdeh.utils.normalizePhone
import ir.sharif.vamdeh.webservices.WebserviceHelper
import ir.sharif.vamdeh.webservices.base.WebserviceException
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class SendVerificationCodeJob : Job() {

    companion object {
        const val TAG = "send_verification_code_tag"
    }

    override fun onRunJob(params: Params): Result {
        val phone = normalizePhone(params.extras.getString(JobConstants.PHONE_NUMBER, ""))
        val code = params.extras.getString(JobConstants.VERIFICATION_CODE, "")
        return try {
            WebserviceHelper.sendVerificationCode(phone, code)
            EventBus.getDefault().post(SendVerificationCodeEvent(phone, code))
            Result.SUCCESS
        } catch (e: WebserviceException) {
            EventBus.getDefault().post(SendVerificationCodeErrorEvent(e.message!!))
            Result.FAILURE
        }
    }

}