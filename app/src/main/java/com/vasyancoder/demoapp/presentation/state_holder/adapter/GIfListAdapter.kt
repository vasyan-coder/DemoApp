package com.vasyancoder.demoapp.presentation.state_holder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.vasyancoder.demoapp.databinding.GifItemBinding
import com.vasyancoder.demoapp.domain.entity.DataGif

class GIfListAdapter : ListAdapter<DataGif, GIfListAdapter.GifListViewHolder>(GifDiffCallback) {

    class GifListViewHolder(val binding: GifItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifListViewHolder {
        val binding = GifItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GifListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GifListViewHolder, position: Int) {
        val gifItem = getItem(position)
        Glide.with(holder.itemView.context)
            .load(gifItem.url)
            .into(holder.binding.gifImageView)
    }
}