package ir.sharif.vamdeh.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.model.CertifiedPerson
import ir.sharif.vamdeh.view.viewholder.TrustedUserVH
import ir.sharif.vamdeh.webservices.webservices.models.TrustedUser

/**
 * Created by mahdihs76 on 12/18/18.
 */
class TrustedPeopleAdapter(private val items: ArrayList<TrustedUser>) : RecyclerView.Adapter<TrustedUserVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TrustedUserVH(LayoutInflater.from(parent.context).inflate(R.layout.certified_person_item, null))

    override fun onBindViewHolder(holder: TrustedUserVH, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    fun updateList(items: List<TrustedUser>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}