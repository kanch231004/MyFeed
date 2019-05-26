package com.cnx.myfeed.models
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cnx.myfeed.data.converters.CommentsConverter
import com.cnx.myfeed.data.converters.Converters
import com.cnx.myfeed.data.converters.ListConverter
import com.google.gson.annotations.SerializedName


data class FeedModel(
    @SerializedName("data")
    var data: List<Feed>,
    @SerializedName("message")
    var message: String,
    @SerializedName("status")
    var status: Boolean
)

@Entity
data class Feed(
    @PrimaryKey(autoGenerate = true) val feedId : Int,
    @Embedded(prefix = "article") @SerializedName("article")
    var article: Article,
    @SerializedName("creator")
    @Embedded(prefix = "creator") var creator: Creator
)

data class Article(
    @SerializedName("akey")
    var akey: Long,
    @SerializedName("center_id")
    var centerId: Int,
    @SerializedName("center_name")
    var centerName: String,
    @SerializedName("city_name")
    var cityName: String,
    @SerializedName("comments")
    @TypeConverters(CommentsConverter::class)
    var comments: ArrayList<Comment>,
    @SerializedName("content")
    var content: String,
    @SerializedName("image_loc")
    var imageLoc: String? = "",
    @TypeConverters(Converters::class)
    @SerializedName("likes")
    var likes: ArrayList<Like>,
    @SerializedName("timelog")
    var timelog: Long,
    @SerializedName("articleFeedId")
    var articleFeedId : Long

)

data class Like(
    @SerializedName("center")
    var center: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("company")
    var company: String,
    @SerializedName("image_loc")
    var imageLoc: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("pkey")
    var pkey: Int,
    @SerializedName("timelog")
    var timelog: Long
)

data class Creator(
    @SerializedName("center")
    var center: String,
    @SerializedName("center_name")
    var centerName: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("city_name")
    var cityName: String,
    @SerializedName("company")
    var company: String,
    @SerializedName("image_loc")
    var imageLoc: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("pkey")
    var pkey: Int
)
data class Comment(
    @SerializedName("center")
    var center: String,
    @SerializedName("city")
    var city: String,
    @SerializedName("ckey")
    var ckey: Int,
    @SerializedName("company")
    var company: String,
    @TypeConverters(ListConverter::class)
    @SerializedName("content")
    var content: ArrayList<String>,
    @SerializedName("image_loc")
    var imageLoc: String?,
    @SerializedName("name")
    var name: String,
    @SerializedName("pkey")
    var pkey: Int,
    @SerializedName("timelog")
    var timelog: Long
)
