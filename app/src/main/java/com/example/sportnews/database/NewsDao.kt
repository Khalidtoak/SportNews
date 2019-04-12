package com.example.sportnews.database

import androidx.room.*

@Dao
interface NewsDao {

        @Insert
        fun insertSaved(savedEntity: NewsEntity)
        @Delete
        fun deleteSaved(savedEntity: NewsEntity)
        @Update(onConflict = OnConflictStrategy.REPLACE)
        fun updateSaved(savedEntity: NewsEntity)

        @Query("SELECT * FROM savedNews")
        fun getAllSaved() : List<NewsEntity>

        @Query("SELECT * FROM savedNews WHERE id = :id")
        fun getOneSaved(id : Int) : NewsEntity

        //////////////////////////////////////

      //  @Insert
      //  fun insertFav(favEntity: FavEntity)
      //  @Delete
      //  fun deleteFav(favEntity: FavEntity)
     //   @Update(onConflict = OnConflictStrategy.REPLACE)
     //   fun updateFav(favEntity: FavEntity)

     //   @Query("SELECT * FROM favNews")
       // fun getAllFav() : List<FavEntity>

      //  @Query("SELECT * FROM favNews WHERE id = :id")
     //   fun getOneFav(id : Int) : FavEntity

}