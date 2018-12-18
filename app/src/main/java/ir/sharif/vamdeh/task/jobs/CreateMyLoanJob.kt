package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.CreateMyLoanEvent
import ir.sharif.vamdeh.task.events.VerificationEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class CreateMyLoanJob : Job() {

    companion object { const val TAG = "create_my_loan_tag" }

    override fun onRunJob(params: Params): Result {
        val amount = params.extras.getInt(JobConstants.AMOUNT, 0)
        val timeToReturnMoney= params.extras.getInt(JobConstants.TIME_TO_RETURN_MONEY, 0)
        val status = params.extras.getString(JobConstants.STATUS, "")
        WebserviceHelper.createMyLoan(amount, timeToReturnMoney, status)
        EventBus.getDefault().post(CreateMyLoanEvent())
        return Result.SUCCESS
    }

}