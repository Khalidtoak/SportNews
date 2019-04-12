package com.example.sportnews.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class RetroClient {

        companion object {
            //base url
            private const val baseUrl = "http://newsapi.org/v2/"
            fun getRetrofit (): Retrofit {
                //initialize retrofit with the base url and gson conveters
                return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
        }
//api key === 76e05fa7414946f0a4a5e283bd2229b6
    //https://newsapi.org/v2/top-headlines?country=gb&category=sport&apiKey=76e05fa7414946f0a4a5e283bd2229b6

}