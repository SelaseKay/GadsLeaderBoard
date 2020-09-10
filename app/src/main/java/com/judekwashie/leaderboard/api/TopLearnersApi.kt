package com.judekwashie.leaderboard.api

import com.judekwashie.leaderboard.TopLearners
import retrofit2.Call
import retrofit2.http.GET

interface TopLearnersApi {
    @GET("api/hours")
    fun getTopLearners(): Call<ArrayList<TopLearners>>
}