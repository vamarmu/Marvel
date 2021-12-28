package com.vamarmu.marvel.ui.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vamarmu.marvel.R
import com.vamarmu.marvel.databinding.ListItemBinding
import kotlin.properties.Delegates


class ListAdapter(items : List<Item> = emptyList() , private val onClickItem:(Item) -> Unit ) :
    RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    var items: List<Item> by Delegates.observable(items){ _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClickItem(item) }
    }

    override fun getItemCount(): Int = items.size


    inner class ItemViewHolder (private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : Item){
            with(binding){
                itemTitle.text = item.title
                Glide.with(this@ItemViewHolder.itemView.context).load(item.thumb).into(itemThumb)
            }
        }
    }
}