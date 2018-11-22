package ir.sharif.vamdeh.task

import com.evernote.android.job.JobCreator
import ir.sharif.vamdeh.task.jobs.RegisterJob

/**
 * Created by mahdihs76 on 11/22/18.
 */
class MyJobCreator : JobCreator {
    override fun create(tag: String) = when (tag) {
        JobConstants.REGISTER_TAG -> RegisterJob()
        else -> null
    }

}