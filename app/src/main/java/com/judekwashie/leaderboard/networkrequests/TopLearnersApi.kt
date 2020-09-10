package com.judekwashie.leaderboard.networkrequests

import com.judekwashie.leaderboard.models.TopLearners
import retrofit2.Call
import retrofit2.http.GET

interface TopLearnersApi {
    @GET("api/hours")
    fun getTopLearners(): Call<ArrayList<TopLearners>>
}