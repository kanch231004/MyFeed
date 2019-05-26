package com.cnx.myfeed.data.converters

import androidx.room.TypeConverter
import com.cnx.myfeed.models.Comment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CommentsConverter {

    @TypeConverter
    fun fromString(value : String): ArrayList<Comment> {

        val listType = object : TypeToken<ArrayList<Comment>>() {}.type
        return Gson().fromJson(value, listType)

    }

    @TypeConverter
    fun fromArrayList(list: ArrayList<Comment>): String {

        val gson = Gson()
        return gson.toJson(list)
    }
}