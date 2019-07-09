package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import ir.sharif.vamdeh.ApplicationContext
import ir.sharif.vamdeh.cache.CacheConstants
import ir.sharif.vamdeh.cache.defaultCache
import ir.sharif.vamdeh.cache.get
import ir.sharif.vamdeh.task.JobConstants
import ir.sharif.vamdeh.task.events.LoginEvent
import ir.sharif.vamdeh.task.events.RegisterEvent
import ir.sharif.vamdeh.task.events.TrustRequestErrorEvent
import ir.sharif.vamdeh.task.events.TrustRequestEvent
import ir.sharif.vamdeh.utils.normalizePhone
import ir.sharif.vamdeh.webservices.WebserviceHelper
import ir.sharif.vamdeh.webservices.base.WebserviceException
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class TrustRequestJob : Job() {

    companion object { const val TAG = "trust_request_tag" }

    override fun onRunJob(params: Params): Result {
        val phoneNumber = params.extras.getString(JobConstants.PHONE_NUMBER, "")
        val trustValue = params.extras.getInt(JobConstants.TRUST_VALUE, 0)
        return try {
            WebserviceHelper.createTrustRequestAsTrustier(normalizePhone(phoneNumber), trustValue)
            EventBus.getDefault().post(TrustRequestEvent())
            Result.SUCCESS
        } catch (e: WebserviceException) {
            EventBus.getDefault().post(TrustRequestErrorEvent(e.message + ""))
            Result.FAILURE
        }
    }

}