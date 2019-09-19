package com.cnx.myfeed

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.cnx.myfeed.databinding.RvFeedItemsBinding
import com.cnx.myfeed.models.Feed

class FeedViewHolder(private val binding : RvFeedItemsBinding) : RecyclerView.ViewHolder( binding.root ) {

    fun bind(item : Feed?) {

        Log.d("FeedVH", "  bind method called")
        binding.apply {

            feed = item
            executePendingBindings()
        }

       /* with(itemView) {


          //  tvLocation.text = "${feed?.creator?.centerName}, ${feed?.creator?.cityName}"
          //  tvName.text = feed?.creator?.name
         //   tvDescription.text = feed?.article?.content
            tvNoOfLikes.text = feed?.article?.likes?.size.toString()+" Likes"
          //  tvOrganisation.text = feed?.creator?.company
          //  tvTime.text = getTimeStamp(feed?.article?.timelog ?: 0L)
         //   Glide.with(itemView).load(feed?.creator?.imageLoc).placeholder(R.drawable.image_dummy).into(civProfile)
         //   Glide.with(itemView).load(feed?.article?.imageLoc).into(ivArticle)

            tvDescription.setOnClickListener { tvDescription.maxLines = Int.MAX_VALUE }


        }*/
    }

}