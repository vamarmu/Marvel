package com.vamarmu.marvel.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vamarmu.domain.AspectRatioImage
import com.vamarmu.marvel.R
import com.vamarmu.marvel.databinding.ListItemBinding
import com.vamarmu.marvel.ui.extension.getUrlWithAspectRatio
import kotlin.properties.Delegates


class ListAdapter(itemDataViews : List<ItemDataView> = emptyList(), private val onClickItem:(ItemDataView) -> Unit ) :
    RecyclerView.Adapter<ListAdapter.ItemViewHolder>() {

    var itemDataViews: List<ItemDataView> by Delegates.observable(itemDataViews){ _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemDataViews[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { onClickItem(item) }
    }

    override fun getItemCount(): Int = itemDataViews.size


    inner class ItemViewHolder (private val binding : ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(itemDataView : ItemDataView){
            with(binding){
                itemTitle.text = itemDataView.title
                Glide.with(this@ItemViewHolder.itemView.context).load(itemDataView.thumbnail.getUrlWithAspectRatio(AspectRatioImage.standard_fantastic)?: R.drawable.ic_launcher_foreground).into(itemThumbnail)
            }
        }
    }
}