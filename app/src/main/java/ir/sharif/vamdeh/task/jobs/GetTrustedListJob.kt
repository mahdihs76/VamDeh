package ir.sharif.vamdeh.task.jobs

import com.evernote.android.job.Job
import ir.sharif.vamdeh.task.events.*
import ir.sharif.vamdeh.webservices.WebserviceHelper
import ir.sharif.vamdeh.webservices.base.WebserviceException
import org.greenrobot.eventbus.EventBus

/**
 * Created by mahdihs76 on 11/22/18.
 */
class GetTrustedListJob : Job() {

    companion object { const val TAG = "get_trusted_list" }

    override fun onRunJob(params: Params): Result {
        return try {
            val list = WebserviceHelper.getMyTrustedPeopleList()
            EventBus.getDefault().post(TrustedPeopleEvent(list.map { people -> people.user }))
            Result.SUCCESS
        } catch (e: WebserviceException) {
            EventBus.getDefault().post(TrustRequestErrorEvent(e.message + ""))
            Result.FAILURE
        }
    }

}