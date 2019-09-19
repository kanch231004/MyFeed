package com.cnx.myfeed.workers

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.cnx.myfeed.data.AppDatabase
import com.cnx.myfeed.models.FeedModel
import com.cnx.myfeed.utilities.FEED_DATA_FILENAME
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import kotlinx.coroutines.coroutineScope


class FeedDatabaseWorker(
    context: Context,
    workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    private val TAG by lazy { FeedDatabaseWorker::class.java.simpleName }

    override suspend fun doWork(): Result = coroutineScope {

        try {

            applicationContext.assets.open(FEED_DATA_FILENAME).use { inputStream ->
                JsonReader(inputStream.reader()).use { jsonReader ->


                    val feedModelType = object : TypeToken<FeedModel>() {}.type
                    val feedModel : FeedModel= Gson().fromJson(jsonReader, feedModelType)

                    Log.e("FeedWorker"," feedModel $feedModel")
                    val database = AppDatabase.getInstance(applicationContext)
                    database.feedDao().insertAll(feedModel.data)

                    Result.success()
                }
            }
        } catch (ex: Exception) {
            Log.e(TAG, "Error feeding database", ex)
            Result.failure()
        }
    }
}