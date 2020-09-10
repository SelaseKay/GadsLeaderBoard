package com.judekwashie.leaderboard

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val GET_REQUEST_URL = "https://gadsapi.herokuapp.com/"
    private val POST_REQUEST_URL = "https://docs.google.com/forms/d/e/"

    fun getInstanceForGetRequest(): Retrofit{
        return Retrofit.Builder().baseUrl(GET_REQUEST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getInstanceForPostRequest(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(POST_REQUEST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}