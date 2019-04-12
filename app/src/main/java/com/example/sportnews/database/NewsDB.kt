package com.example.sportnews.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DATABASE_NAME = "news_db"
@Database(entities = [NewsEntity::class], version = 1, exportSchema = false)
abstract class NewsDB : RoomDatabase(){
    //abstract function that returns  the Dao
    abstract fun getNewsDao() : NewsDao

    //inside this companion object , we initialize the database
    companion object {
        private var databaseInstance : NewsDB? = null
        fun initializeDb(context: Context) : NewsDB? {
            if (databaseInstance == null) {
                databaseInstance = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDB::class.java, DATABASE_NAME
                ).build()
            }
            return databaseInstance
        }
    }
}