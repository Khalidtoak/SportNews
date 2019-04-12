package com.example.sportnews.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "savedNews")
data class NewsEntity(
    val newsTitle:String?,
    val newsContent : String?,
    val newsDateSaved : String?,
    val newsSource : String?,
    val newsImageUrl : String?,
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0
)

//@Entity(tableName = "favNews")
//data class FavEntity(
  //  val title:String?,
   // val content : String?,
   // val imageUrl : String?,
   // @PrimaryKey(autoGenerate = true)
    //val id : Int = 0
//)