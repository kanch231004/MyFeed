package com.cnx.myfeed.viewModels

import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.cnx.myfeed.data.FeedRepository

class MyFeedViewModel internal constructor(feedRepository: FeedRepository): ViewModel() {



   val feeds  = feedRepository.getFeeds()
      .toLiveData(Config(4, enablePlaceholders = true, maxSize = 20, prefetchDistance = 2,initialLoadSizeHint = 4))
}