package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.RegisterErrorEvent
import ir.sharif.vamdeh.task.events.RegisterEvent
import ir.sharif.vamdeh.webservices.WebserviceHelper
import ir.sharif.vamdeh.webservices.base.WebserviceException
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class RegisterJob : Job() {

    companion object { const val TAG = "register_tag" }

    override fun onRunJob(params: Params): Result {
        val password = params.extras.getString(JobConstants.PASSWORD, "")
        val code = params.extras.getString(JobConstants.VERIFICATION_CODE, "")
        return try {
            WebserviceHelper.register(ApplicationContext.context, defaultCache()[CacheConstants.KEY_PHONE] , code, password)
            EventBus.getDefault().post(RegisterEvent(password))
            Result.SUCCESS
        } catch (e: WebserviceException) {
            EventBus.getDefault().post(RegisterErrorEvent(e.message + ""))
            Result.FAILURE
        }
    }

}