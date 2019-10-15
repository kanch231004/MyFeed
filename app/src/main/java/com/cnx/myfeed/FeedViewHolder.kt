package com.cnx.myfeed

import androidx.recyclerview.widget.RecyclerView
import com.cnx.myfeed.databinding.RvFeedItemsBinding
import com.cnx.myfeed.models.Feed

class FeedViewHolder(private val binding : RvFeedItemsBinding) : RecyclerView.ViewHolder( binding.root ) {

    fun bind(item : Feed?) {

        binding.apply {

            feed = item
            executePendingBindings()
        }

    }

}