package com.vamarmu.marvel.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.vamarmu.domain.AspectRatioImage
import com.vamarmu.marvel.R
import com.vamarmu.marvel.databinding.ListItemBinding
import com.vamarmu.marvel.ui.extension.getUrlWithAspectRatio



class ItemsListAdapter( private val onClickItem:(ItemDataView) -> Unit, private val onItemsCreated: (position: Int, total: Int)->Unit ) :
    ListAdapter<ItemDataView, ItemsListAdapter.ItemViewHolder>(ITEM_COMPARATOR) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener { onClickItem(item) }
        onItemsCreated(position,itemCount)
    }




    inner class ItemViewHolder (private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemDataView : ItemDataView){
            with(binding){
                itemTitle.text = itemDataView.title
                Glide.with(this@ItemViewHolder.itemView.context).load(itemDataView.thumbnail.getUrlWithAspectRatio(AspectRatioImage.standard_fantastic)?: R.drawable.ic_launcher_foreground).into(itemThumbnail)
            }
        }
    }
    companion object {

        private val ITEM_COMPARATOR = object : DiffUtil.ItemCallback<ItemDataView>() {
            override fun areItemsTheSame(oldItem: ItemDataView, newItem: ItemDataView): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ItemDataView, newItem: ItemDataView): Boolean {
                return oldItem == newItem
            }
        }
    }
}