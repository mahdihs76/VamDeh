package ir.sharif.vamdeh.view.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.view.viewholder.CertifiedPersonVH

/**
 * Created by mahdihs76 on 12/18/18.
 */
class CertifiedPersonAdapter(val items: Array<CertifiedPerson>) : RecyclerView.Adapter<CertifiedPersonVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CertifiedPersonVH(LayoutInflater.from(parent.context).inflate(R.layout.certified_person_item, null))

    override fun onBindViewHolder(holder: CertifiedPersonVH, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size
}