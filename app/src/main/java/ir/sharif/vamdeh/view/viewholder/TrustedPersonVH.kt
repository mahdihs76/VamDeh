package ir.sharif.vamdeh.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.model.TrustedPerson
import kotlinx.android.synthetic.main.trusted_person_item.view.*

/**
 * Created by mahdihs76 on 12/25/18.
 */
class TrustedPersonVH(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(person: TrustedPerson) = with(view) {
        nameTextView.text = person.name
        phoneTextView.text = person.phoneNumber
        trustedDateTextView.text = person.trustedData
    }
}

