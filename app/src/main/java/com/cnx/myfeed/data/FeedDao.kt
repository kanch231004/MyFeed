package com.cnx.myfeed.data

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cnx.myfeed.models.Feed

@Dao
interface FeedDao {

    @Query("Select * from Feed")
    fun getFeeds() : DataSource.Factory<Int,Feed>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(feeds: List<Feed>)
}
