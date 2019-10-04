package ir.sharif

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.evernote.android.job.JobManager
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import es.dmoral.toasty.Toasty
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.set
import ir.sharif.vamdeh.task.MyJobCreator
import ir.sharif.vamdeh.utils.getAppTypeface
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

        Toasty.Config.getInstance()
                .setToastTypeface(getAppTypeface())
                .setTextSize(14)
                .apply()

        FirebaseInstanceId.getInstance().instanceId
                .addOnCompleteListener(OnCompleteListener { task ->
                    if (!task.isSuccessful) {
                        Log.w("TAG", "getInstanceId failed", task.exception)
                        return@OnCompleteListener
                    }

                    // Get new Instance ID token
                    val token = task.result?.token
                    defaultCache()["fcm_token"] = token
                })
    }
}