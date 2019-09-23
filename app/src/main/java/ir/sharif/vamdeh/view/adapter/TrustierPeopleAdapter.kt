package ir.sharif.vamdeh.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.view.viewholder.TrustierUserVH
import ir.sharif.vamdeh.webservices.webservices.models.User
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trusted_me_people_list.get_my_trusted_people_list.GetTrustierPeopleListResponse

/**
 * Created by mahdihs76 on 12/18/18.
 */
class TrustierPeopleAdapter(val items: ArrayList<GetTrustierPeopleListResponse>) : RecyclerView.Adapter<TrustierUserVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TrustierUserVH(LayoutInflater.from(parent.context).inflate(R.layout.trusted_person_item, null))

    override fun onBindViewHolder(holder: TrustierUserVH, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    fun updateList(items: List<GetTrustierPeopleListResponse>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }
}