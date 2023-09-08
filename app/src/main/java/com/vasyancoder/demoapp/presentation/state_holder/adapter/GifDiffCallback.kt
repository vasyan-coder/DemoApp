package com.vasyancoder.demoapp.presentation.state_holder.adapter

import androidx.recyclerview.widget.DiffUtil
import com.vasyancoder.demoapp.domain.entity.DataGif

object GifDiffCallback : DiffUtil.ItemCallback<DataGif>() {
    override fun areItemsTheSame(oldItem: DataGif, newItem: DataGif): Boolean {
        return oldItem.url == newItem.url
    }

    override fun areContentsTheSame(oldItem: DataGif, newItem: DataGif): Boolean {
        return oldItem == newItem
    }

}