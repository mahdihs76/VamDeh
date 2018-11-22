package ir.sharif

import android.app.Application
import com.evernote.android.job.JobManager
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.task.MyJobCreator

/**
 *
 * Created by mahdihs76 on 9/11/18.
 */
class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ApplicationContext.initialize(this)
        JobManager.create(this).addJobCreator(MyJobCreator())
    }
}