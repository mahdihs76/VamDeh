package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.LoginEvent
import ir.sharif.vamdeh.task.events.RegisterEvent
import ir.sharif.vamdeh.utils.normalizePhone
import ir.sharif.vamdeh.webservices.WebserviceHelper
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class LoginJob : Job() {

    companion object { const val TAG = "login_tag" }

    override fun onRunJob(params: Params): Result {
        return try {
            WebserviceHelper.login(ApplicationContext.context,
                    normalizePhone(defaultCache()[CacheConstants.KEY_PHONE]!!),
                    defaultCache()[CacheConstants.KEY_PASSWORD])
            EventBus.getDefault().post(LoginEvent(true))
            Result.SUCCESS
        } catch (e: Exception) {
            EventBus.getDefault().post(LoginEvent(false))
            Result.FAILURE
        }
    }

}