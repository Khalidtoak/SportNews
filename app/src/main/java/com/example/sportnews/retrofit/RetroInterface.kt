package com.example.sportnews.retrofit

import com.example.sportnews.datamodel.SportNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroInterface {
    //specify the endpoint to get popular movies from
    @GET("top-headlines")
    fun getLatestNews(@Query("api_key") apiKey :String,
                         @Query("country") country : String,
                         @Query("category") category : String) : Call<SportNews>
}