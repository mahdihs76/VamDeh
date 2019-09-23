package ir.sharif.vamdeh.view.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.sharif.vamdeh.R
import ir.sharif.vamdeh.view.viewholder.TrustedUserVH
import ir.sharif.vamdeh.webservices.webservices.models.User

/**
 * Created by mahdihs76 on 12/18/18.
 */
class TrustedPeopleAdapter(private val items: ArrayList<User>,
                           private val listener: TrustedPeopleListener)
    : RecyclerView.Adapter<TrustedUserVH>() {

    private lateinit var recyclerView: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        this.recyclerView = recyclerView
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrustedUserVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.certified_person_item, null)
        view.setOnClickListener { onClick(view) }
        return TrustedUserVH(view)
    }

    override fun onBindViewHolder(holder: TrustedUserVH, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    fun updateList(items: List<User>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    private fun onClick(view: View) =
            listener.onTrustedPersonClick(items[recyclerView.getChildLayoutPosition(view)])

    interface TrustedPeopleListener {
        fun onTrustedPersonClick(person: User)
    }
}