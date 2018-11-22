package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import com.evernote.android.job.JobRequest
import com.evernote.android.job.util.support.PersistableBundleCompat
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.RegisterEvent
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class RegisterJob : Job() {

    override fun onRunJob(params: Params): Result {

        val phone = params.extras.get(JobConstants.PHONE_NUMBER)

        EventBus.getDefault().post(RegisterEvent(false))
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
