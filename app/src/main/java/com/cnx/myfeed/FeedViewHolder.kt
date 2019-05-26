package com.cnx.myfeed

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cnx.myfeed.extensions.getTimeStamp
import com.cnx.myfeed.models.Feed
import kotlinx.android.synthetic.main.rv_feed_items.view.*

class FeedViewHolder(itemView : View) : RecyclerView.ViewHolder( itemView ) {

    fun bind(feed : Feed?) {

        with(itemView) {


            tvLocation.text = "${feed?.creator?.centerName}, ${feed?.creator?.cityName}"
            tvName.text = feed?.creator?.name
            tvDescription.text = feed?.article?.content
            tvNoOfLikes.text = feed?.article?.likes?.size.toString()+" Likes"
            tvOrganisation.text = feed?.creator?.company
            tvTime.text = getTimeStamp(feed?.article?.timelog ?: 0L)
            Glide.with(itemView).load(feed?.creator?.imageLoc).placeholder(R.drawable.image_dummy).into(civProfile)


        }
    }

}