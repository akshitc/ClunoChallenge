package com.akshit.clunochallenge.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.akshit.clunochallenge.R
import com.akshit.clunochallenge.model.ClunoListItem
import com.squareup.picasso.Picasso

class ClunoListAdapter(
    val items: List<ClunoListItem>,
    val itemClickListener: OnItemClickListener
) :
    RecyclerView.Adapter<ClunoListAdapter.ClunoListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClunoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cluno_list_item, parent, false)
        return ClunoListViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(viewHolder: ClunoListViewHolder, position: Int) {
        viewHolder.bind(items[position])
    }

    inner class ClunoListViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val make: TextView = view.findViewById(R.id.make)
        private val model: TextView = view.findViewById(R.id.model)
        private val carImage: ImageView = view.findViewById(R.id.carImage)
        private val price: TextView = view.findViewById(R.id.price)

        init {
            view.setOnClickListener {
                itemClickListener.onItemClick(items[this.adapterPosition])
            }
        }

        fun bind(clunoListItem: ClunoListItem) {
            make.text = clunoListItem.car.make
            model.text = clunoListItem.car.model
            Picasso.get().load(clunoListItem.teaser.teaserImage).into(carImage)
            price.text = clunoListItem.pricing.price.toString() + clunoListItem.pricing.currencySymbol
        }
    }
}