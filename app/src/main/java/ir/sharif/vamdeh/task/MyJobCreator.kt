package ir.sharif.vamdeh.task

import com.evernote.android.job.JobCreator
import ir.sharif.vamdeh.task.jobs.GetProfileJob
import ir.sharif.vamdeh.task.jobs.VerificationJob
import ir.sharif.vamdeh.task.jobs.SaveProfileJob

/**
 * Created by mahdihs76 on 11/22/18.
 */
class MyJobCreator : JobCreator {
    override fun create(tag: String) = when (tag) {
        JobConstants.VERIFICATION_TAG -> VerificationJob()
        JobConstants.SAVE_PROFILE_TAG -> SaveProfileJob()
        JobConstants.GET_PROFILE_TAG -> GetProfileJob()
        else -> null
    }

}