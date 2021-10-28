package com.oride.recyclerviewdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.oride.recyclerviewdemo.databinding.SimpleGridItemBinding
import com.oride.recyclerviewdemo.databinding.SimpleSingleItemBinding
import com.oride.recyclerviewdemo.databinding.SimpleTitleItemBinding

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    val differ by lazy {
        AsyncListDiffer(this, object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return when (viewType) {
            R.layout.simple_single_item -> {
                ItemViewHolder.SingleItemViewHolder(
                    SimpleSingleItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            R.layout.simple_title_item -> {
                ItemViewHolder.TitleItemViewHolder(
                    SimpleTitleItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            R.layout.simple_grid_item -> {
                ItemViewHolder.GridItemViewHolder(
                    SimpleGridItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent, false
                    )
                )
            }
            else -> throw IllegalArgumentException("Invalid ViewType provided")
        }
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        when (holder) {
            is ItemViewHolder.GridItemViewHolder -> {
                holder.binding.tvTitle.text = differ.currentList[position].name
            }
            is ItemViewHolder.SingleItemViewHolder -> {

            }
            is ItemViewHolder.TitleItemViewHolder -> {
                holder.binding.tvTitle.text = differ.currentList[position].name
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (Item.getType(differ.currentList[position].type)) {
            Item.Type.Grid -> R.layout.simple_grid_item
            Item.Type.Single -> R.layout.simple_single_item
            Item.Type.Title -> R.layout.simple_title_item
        }
    }

    override fun getItemCount() = differ.currentList.size
}