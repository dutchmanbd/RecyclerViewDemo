package com.oride.recyclerviewdemo

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.oride.recyclerviewdemo.databinding.SimpleGridItemBinding
import com.oride.recyclerviewdemo.databinding.SimpleSingleItemBinding
import com.oride.recyclerviewdemo.databinding.SimpleTitleItemBinding

sealed class ItemViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class SingleItemViewHolder(val binding: SimpleSingleItemBinding) : ItemViewHolder(binding)
    class TitleItemViewHolder(val binding: SimpleTitleItemBinding) : ItemViewHolder(binding)
    class GridItemViewHolder(val binding: SimpleGridItemBinding) : ItemViewHolder(binding)
}
