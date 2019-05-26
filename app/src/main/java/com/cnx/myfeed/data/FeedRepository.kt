package com.cnx.myfeed.data

class FeedRepository private constructor(private val feedDao: FeedDao) {


    fun getFeeds() = feedDao.getFeeds()

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: FeedRepository? = null

        fun getInstance(feedDao: FeedDao) =
            instance ?: synchronized(this) {
                instance ?: FeedRepository(feedDao).also { instance = it }
            }
    }
}