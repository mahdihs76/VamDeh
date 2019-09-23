package ir.sharif.vamdeh.activity.operations

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.activity.base.BaseActivity
import ir.sharif.vamdeh.helper.*
import ir.sharif.vamdeh.view.adapter.TrustierPeopleAdapter
import ir.sharif.vamdeh.webservices.base.MyRetrofit
import ir.sharif.vamdeh.webservices.base.WebserviceUrls
import kotlinx.android.synthetic.main.activity_trusted.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TrustierPeopleActivity : BaseActivity() {

    private lateinit var adapter: TrustierPeopleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trusted)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TrustierPeopleAdapter(ArrayList())

        recyclerView.adapter = adapter

        backImageView.setOnClickListener { onBackPressed() }

        sendInviteLink.setOnClickListener { openContacts(PICK_CONTACT_CODE)}

        CoroutineScope(Dispatchers.Main).launch { updateTrustierPeopleList() }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data ?: return
        if (requestCode == PICK_CONTACT_CODE && resultCode == Activity.RESULT_OK) {
            runWithPermissions(Manifest.permission.READ_CONTACTS) {
                val contact = fetchContact(data)
                val service = MyRetrofit.getInstance().webserviceUrls
                CoroutineScope(Dispatchers.Main).launch {
                    try {
                        service.createTrustRequest(contact.phone)
                        updateTrustierPeopleList()
                    }catch (e: Exception){
                        toastError(e.message.toString())
                    }
                }
            }
        }

    }

    private suspend fun updateTrustierPeopleList() {
        val response = MyRetrofit.getInstance().webserviceUrls.getTrustierPeopleList()
        if (response.isSuccessful) {
            adapter.updateList(response.body()!!)
        }
    }
}
