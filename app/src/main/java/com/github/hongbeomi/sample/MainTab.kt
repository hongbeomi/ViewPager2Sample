package com.github.hongbeomi.sample

import androidx.annotation.ColorInt
import com.github.hongbeomi.sample.SimpleItemCallback.DiffCallback

data class MainTab(
    val title: String,
    @ColorInt
    val backgroundColor: Int
) : DiffCallback