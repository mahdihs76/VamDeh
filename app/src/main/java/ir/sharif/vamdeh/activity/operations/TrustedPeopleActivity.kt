package ir.sharif.vamdeh.activity.operations

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.task.events.TrustRequestErrorEvent
import ir.sharif.vamdeh.task.events.TrustRequestEvent
import ir.sharif.vamdeh.task.events.TrustedPeopleEvent
import ir.sharif.vamdeh.task.jobs.GetTrustedListJob
import ir.sharif.vamdeh.task.jobs.TrustRequestJob
import ir.sharif.vamdeh.view.adapter.TrustedPeopleAdapter
import ir.sharif.vamdeh.webservices.WebserviceHelper
import ir.sharif.vamdeh.webservices.webservices.models.User
import kotlinx.android.synthetic.main.activity_certified.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.lang.Exception
import kotlin.concurrent.thread

class TrustedPeopleActivity : BaseActivityJobSupport(), TrustedPeopleAdapter.TrustedPeopleListener {
    private lateinit var adapter: TrustedPeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certified)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        adapter = TrustedPeopleAdapter(ArrayList(), this)
        recyclerView.adapter = adapter

        addPerson.setOnClickListener { openContacts(PICK_CONTACT_CODE) }
        backImageView.setOnClickListener { onBackPressed() }

        getTrustedPeopleList()
    }

    private fun getTrustedPeopleList() = scheduleJob(GetTrustedListJob.TAG)

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data ?: return
        if (requestCode == PICK_CONTACT_CODE && resultCode == Activity.RESULT_OK) {
            runWithPermissions(Manifest.permission.READ_CONTACTS) {
                val contact = fetchContact(data)
                MaterialDialog(this).show {
                    title(R.string.add_certified_person)
                    message(R.string.add_certified_person_description)
                    input { _, text ->
                        scheduleJob(
                                TrustRequestJob.TAG,
                                getTrustRequestExtras(
                                        contact.phone,
                                        text.toString().toInt()
                                )
                        )
                    }
                }
            }
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: TrustedPeopleEvent) =
            runOnUiThread { adapter.updateList(event.people) }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: TrustRequestEvent) = getTrustedPeopleList().also {
        toastSuccess(getString(R.string.trust_successful))
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: TrustRequestErrorEvent) = toastError(event.text)

    override fun onTrustedPersonClick(person: User) {
        MaterialDialog(this).show {
            title(text = "آپدیت مقدار اعتماد")
            message(text = "مقدار جدید را برای این فرد وارد کنید.")
            input { _, text -> thread(true){
                try {
                    WebserviceHelper.updateMyTrustRelationValue(
                            person.mobilePhoneNumber,
                            text.toString().toInt())
                    runOnUiThread {  toastSuccess("مقدار جدید با موفقیت اعمال شد") }
                }catch (e: Exception){
                    runOnUiThread {  toastError(e.message.toString()) }
                }
            } }
        }
    }
}
