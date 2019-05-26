package com.cnx.myfeed.extensions

import com.cnx.myfeed.utilities.DAY_MILLIS
import com.cnx.myfeed.utilities.HOUR_MILLIS
import com.cnx.myfeed.utilities.MINUTE_MILLIS


fun getTimeStamp(time : Long) : String {



    val now = System.currentTimeMillis()
    val diff = now - time;

    return when {
        diff < MINUTE_MILLIS -> "just now"
        diff < 2 * MINUTE_MILLIS -> " minute ago"
        diff < 50 * MINUTE_MILLIS -> "${diff / HOUR_MILLIS} mins ago"
        diff < 90 * MINUTE_MILLIS -> " hour ago"
        diff < 24 * HOUR_MILLIS -> "${diff / HOUR_MILLIS} hours ago"
        diff < 48 * HOUR_MILLIS -> "yesterday"
        else -> "${diff / DAY_MILLIS} days ago"
    }
}