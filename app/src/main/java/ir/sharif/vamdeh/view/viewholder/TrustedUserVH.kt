package ir.sharif.vamdeh.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.webservices.webservices.models.TrustedUser
import kotlinx.android.synthetic.main.certified_person_item.view.*

/**
 * Created by mahdihs76 on 12/18/18.
 */
class TrustedUserVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(person: TrustedUser) = with(view) {
        val user = person.user
        nameTextView.text = user.firstName.plus(" ").plus(user.lastName)
        avatarImageView.setImageResource(R.mipmap.me)
    }
}

