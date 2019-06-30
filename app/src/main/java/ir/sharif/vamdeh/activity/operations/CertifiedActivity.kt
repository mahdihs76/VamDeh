package ir.sharif.vamdeh.activity.operations

import android.Manifest
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.GridLayoutManager
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import ir.sharif.vamdeh.activity.base.BaseActivityJobSupport
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.task.events.GetMyScoresEvent
import ir.sharif.vamdeh.task.events.TrustRequestEvent
import ir.sharif.vamdeh.task.jobs.TrustRequestJob
import ir.sharif.vamdeh.view.adapter.CertifiedPersonAdapter
import kotlinx.android.synthetic.main.activity_certified.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick

const val PICK_CONTACT_CODE = 1000

class CertifiedActivity : BaseActivityJobSupport() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_certified)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = CertifiedPersonAdapter(arrayOf(CertifiedPerson("مهدی حسن زاده", R.mipmap.me), CertifiedPerson("مهدی حسن زاده", R.mipmap.me), CertifiedPerson("مهدی حسن زاده", R.mipmap.me), CertifiedPerson("مهدی حسن زاده", R.mipmap.me), CertifiedPerson("مهدی حسن زاده", R.mipmap.me), CertifiedPerson("مهدی حسن زاده", R.mipmap.me), CertifiedPerson("مهدی حسن زاده", R.mipmap.me)))

        addPerson.setOnClickListener { openContacts(PICK_CONTACT_CODE) }
        backImageView.setOnClickListener { onBackPressed() }
    }


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
                        scheduleJob(TrustRequestJob.TAG, getTrustRequestExtras(contact.phone, text.toString().toInt()))
                    }
                }
            }
        }

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: TrustRequestEvent) = toastSuccess(getString(R.string.trust_successful))
}
