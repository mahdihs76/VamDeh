package ir.sharif.vamdeh.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import ir.sharif.vamdeh.model.CertifiedPerson
import kotlinx.android.synthetic.main.certified_person_item.view.*

/**
 * Created by mahdihs76 on 12/18/18.
 */
class CertifiedPersonVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(person: CertifiedPerson) = with(view) {
        nameTextView.text = person.name
        avatarImageView.setImageResource(person.imageId)
    }
}

