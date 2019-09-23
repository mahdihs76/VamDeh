package ir.sharif.vamdeh.view.viewholder

import android.Manifest
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import com.bumptech.glide.Glide
import com.livinglifetechway.quickpermissions_kotlin.runWithPermissions
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.helper.getContactName
import ir.sharif.vamdeh.utils.normalizePhone
import ir.sharif.vamdeh.webservices.webservices.models.User
import kotlinx.android.synthetic.main.certified_person_item.view.*

/**
 * Created by mahdihs76 on 12/18/18.
 */
class TrustedUserVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(person: User) = with(view) {
        val profile = person.profile
        if (profile != null) {
            nameTextView.text = profile.nickName
            val avatar = profile.avatar
            if (avatar.isNullOrEmpty()) {
                avatarImageView.setImageResource(R.drawable.user)
            } else {
                Glide.with(view.context).load(avatar).into(avatarImageView)
            }
        } else {
            var contactName : String? = null
            context.runWithPermissions(Manifest.permission.READ_CONTACTS) {
                contactName = context.getContactName(person.mobilePhoneNumber)
            }
            nameTextView.text = if (contactName.isNullOrEmpty()) {
                normalizePhone(person.mobilePhoneNumber)
            } else {
                contactName
            }
            avatarImageView.setImageResource(R.drawable.user)
        }
    }


}

