package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.SaveProfileEvent
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/30/18.
 */

class SaveProfileJob : Job() {

    override fun onRunJob(params: Params): Result {

        val phone = params.extras.getString(JobConstants.PHONE_NUMBER, "")
//        val response = WebserviceHelper.createMyProfile(ApplicationContext.context, phone, "rahimi7658", "rahimi7658", "mahdihasanzadeh7677@gmail.com")
        EventBus.getDefault().post(SaveProfileEvent(true))
        return Result.SUCCESS
    }

    companion object {
        fun scheduleJob(phone: String) {
            val extras = PersistableBundleCompat().apply { putString(JobConstants.PHONE_NUMBER, phone) }
            JobRequest.Builder(JobConstants.SAVE_PROFILE_TAG)
                    .addExtras(extras)
                    .startNow()
                    .build()
                    .schedule()
        }
    }

}
