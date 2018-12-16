package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.SendVerificationCodeEvent
import ir.sharif.vamdeh.utils.normalizePhone
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class SendVerificationCodeJob : Job() {

    override fun onRunJob(params: Params): Result {

        val phone = params.extras.getString(JobConstants.PHONE_NUMBER, "")
        val code = params.extras.getString(JobConstants.VERIFICATION_CODE, "")
        val response = WebserviceHelper.sendVerificationCode(ApplicationContext.context, normalizePhone(phone), code)
        EventBus.getDefault().post(SendVerificationCodeEvent(phone))
        return Result.SUCCESS
    }

    companion object {
        fun scheduleJob(phone: String, code: String) {
            val extras = PersistableBundleCompat().apply {
                putString(JobConstants.PHONE_NUMBER, phone)
                putString(JobConstants.VERIFICATION_CODE, code)
            }
            JobRequest.Builder(JobConstants.SEND_VERIFICATION_CODE_TAG)
                    .addExtras(extras)
                    .startNow()
                    .build()
                    .schedule()
        }
    }

}