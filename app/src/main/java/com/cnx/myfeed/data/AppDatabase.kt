package com.cnx.myfeed.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.cnx.myfeed.data.converters.CommentsConverter
import com.cnx.myfeed.data.converters.Converters
import com.cnx.myfeed.data.converters.ListConverter
import com.cnx.myfeed.models.Feed
import com.cnx.myfeed.utilities.DATABASE_NAME
import com.cnx.myfeed.workers.FeedDatabaseWorker


@Database(entities = [Feed::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class, ListConverter::class, CommentsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    //abstract fun gardenPlantingDao(): GardenPlantingDao
    abstract fun feedDao(): FeedDao

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database.

        private fun buildDatabase(context: Context): AppDatabase {

            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<FeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }
    }
}
