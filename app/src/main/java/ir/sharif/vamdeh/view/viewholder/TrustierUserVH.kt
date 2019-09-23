package ir.sharif.vamdeh.view.viewholder

import android.Manifest
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.helper.getContactName
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.model.TrustedPerson
import ir.sharif.vamdeh.webservices.webservices.models.User
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trusted_me_people_list.get_my_trusted_people_list.GetTrustierPeopleListResponse
import kotlinx.android.synthetic.main.trusted_person_item.view.*

/**
 * Created by mahdihs76 on 12/25/18.
 */
class TrustierUserVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(person: GetTrustierPeopleListResponse) = with(view) {
        val user = person.trustierUser
        val profile = user.profile

        val nickName = profile?.nickName
        nameTextView.text = if (nickName.isNullOrEmpty()) {
            view.context.runWithPermissions(Manifest.permission.READ_CONTACTS) {
                view.context.getContactName(user.mobilePhoneNumber)
            }
            user.mobilePhoneNumber
        } else {
            nickName
        }
        phoneTextView.text = user.mobilePhoneNumber
        trustedDateTextView.text = person.requestTime
        if (user.isRegistered) {
            inviteLinkTextView.setTextColor(resources.getColor(R.color.gray))
        }
    }
}

