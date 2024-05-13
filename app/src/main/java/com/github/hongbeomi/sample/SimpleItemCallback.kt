package com.github.hongbeomi.sample

import androidx.recyclerview.widget.DiffUtil

class SimpleItemCallback<T : SimpleItemCallback.DiffCallback> : DiffUtil.ItemCallback<T>() {
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.areContentsTheSame(newItem)

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean =
        oldItem.areItemsTheSame(newItem)

    interface DiffCallback {
        fun areItemsTheSame(other: DiffCallback) = (this::class == other::class)
        fun areContentsTheSame(other: DiffCallback) = (this == other)
    }
}