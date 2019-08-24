package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.CreateMyLoanEvent
import ir.sharif.vamdeh.task.events.SendVerificationErrorEvent
import ir.sharif.vamdeh.task.events.SendVerificationEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import ir.sharif.vamdeh.webservices.base.WebserviceException
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class CreateProfileJob : Job() {

    companion object { const val TAG = "create_my_profile" }

    override fun onRunJob(params: Params): Result {
        val fullName = params.extras.getString(JobConstants.FULL_NAME, null)
        val nationalCode = params.extras.getString(JobConstants.NATIONAL_CODE, null)
        val accountNo = params.extras.getString(JobConstants.ACCOUNT_NO, null)
        val cardNo = params.extras.getString(JobConstants.CARD_NO, null)
        val shebaNo = params.extras.getString(JobConstants.SHEBA_NO, null)
        return try {
            WebserviceHelper.createMyProfile(fullName, nationalCode, cardNo, accountNo, shebaNo)
            EventBus.getDefault().post(CreateProfileEvent())
            Result.SUCCESS
        } catch (e: WebserviceException) {
            EventBus.getDefault().post(CreateProfileErrorEvent(e.message!!))
            Result.FAILURE
        }
    }

}

class CreateProfileEvent
data class CreateProfileErrorEvent(val error: String)