package ir.sharif.vamdeh.task

import com.evernote.android.job.JobCreator
import ir.sharif.vamdeh.task.jobs.*

/**
 * Created by mahdihs76 on 11/22/18.
 */
class MyJobCreator : JobCreator {
    override fun create(tag: String) = when (tag) {
        VerificationJob.TAG -> VerificationJob()
        SendVerificationCodeJob.TAG -> SendVerificationCodeJob()
        RegisterJob.TAG -> RegisterJob()
        GetMyScoresJob.TAG-> GetMyScoresJob()
        CreateMyLoanJob.TAG-> CreateMyLoanJob()
        LoginJob.TAG -> LoginJob()
        else -> null
    }

}