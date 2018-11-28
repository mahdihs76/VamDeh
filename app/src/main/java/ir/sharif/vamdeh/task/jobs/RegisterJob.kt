package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.MyApplication
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.RegisterEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.toast

/**
 * Created by mahdihs76 on 11/22/18.
 */
class RegisterJob : Job() {

    override fun onRunJob(params: Params): Result {

        val phone = params.extras.getString(JobConstants.PHONE_NUMBER, "")
        val response = WebserviceHelper.register(ApplicationContext.context, phone, "rahimi7658", "rahimi7658", "mahdihasanzadeh7677@gmail.com")
        EventBus.getDefault().post(RegisterEvent(true))
        return Result.SUCCESS
    }

    companion object {
        fun scheduleJob(phone: String) {
            val extras = PersistableBundleCompat().apply { putString(JobConstants.PHONE_NUMBER, phone) }
            JobRequest.Builder(JobConstants.REGISTER_TAG)
                    .addExtras(extras)
                    .startNow()
                    .build()
                    .schedule()
        }
    }

}
