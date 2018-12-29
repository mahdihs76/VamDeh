package ir.sharif.vamdeh.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.model.TrustedPerson
import ir.sharif.vamdeh.view.viewholder.CertifiedPersonVH
import ir.sharif.vamdeh.view.viewholder.TrustedPersonVH

/**
 * Created by mahdihs76 on 12/18/18.
 */
class TrustedPersonAdapter(val items: Array<TrustedPerson>) : RecyclerView.Adapter<TrustedPersonVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TrustedPersonVH(LayoutInflater.from(parent.context).inflate(R.layout.trusted_person_item, null))

    override fun onBindViewHolder(holder: TrustedPersonVH, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}