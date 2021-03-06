package com.judekwashie.leaderboard.networkrequests

import com.judekwashie.leaderboard.models.TopSkillers
import retrofit2.Call
import retrofit2.http.GET

interface TopSkillersApi {

    @GET("api/skilliq")
    fun getTopSkillers(): Call<ArrayList<TopSkillers>>
}