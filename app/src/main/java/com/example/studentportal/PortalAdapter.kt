package com.example.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_item.view.*

class PortalAdapter(private val portals: List<Portal>) : RecyclerView.Adapter<PortalAdapter.ViewHolder>() {

    /**
     * Called by RecyclerView to display the data at the specified position.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(portals[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        private val tvPortalTitle: TextView = itemView.findViewById(android.R.id.text1)
//        private val tvPortalUrl: TextView = itemView.findViewById(android.R.id.text2)

        fun bind(portal: Portal) {
//            tvPortalTitle.text = portal.title
//            tvPortalUrl.text = portal.url
//            itemView.btnPortal.text = (portal.title + "\n" + portal.url)
            itemView.tvPortalTitle.text = portal.title
            itemView.tvPortalLink.text = portal.url
        }

    }

    /**
     * Creates and returns a ViewHolder object, inflating standard layout file
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.portal_item,
                parent,
                false
            )
        )
    }

    /**
     * Returns the size of the list
     */
    override fun getItemCount(): Int {
        return portals.size
    }
}