package ir.sharif

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.evernote.android.job.JobManager
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.task.MyJobCreator
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting

/**
 *
 * Created by mahdihs76 on 9/11/18.
 */
class MyApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        ApplicationContext.initialize(this)
        WebservicePrefSetting.getInstance(ApplicationContext.context)
        JobManager.create(this).addJobCreator(MyJobCreator())
    }
}