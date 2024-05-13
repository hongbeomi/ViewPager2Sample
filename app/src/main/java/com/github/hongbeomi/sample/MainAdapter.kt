package com.github.hongbeomi.sample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.github.hongbeomi.sample.databinding.ItemMainBinding

class MainAdapter : ListAdapter<MainTab, MainAdapter.ViewHolder>(SimpleItemCallback<MainTab>()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemMainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MainTab) = with(binding.tvTitle) {
            text = item.title
            setBackgroundColor(item.backgroundColor)
        }
    }
}