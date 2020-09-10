package com.judekwashie.leaderboard.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.judekwashie.leaderboard.*
import com.judekwashie.leaderboard.networkrequests.TopLearnersApi
import com.judekwashie.leaderboard.networkrequests.TopSkillersApi
import com.judekwashie.leaderboard.models.TopLearners
import com.judekwashie.leaderboard.models.TopSkillers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LearnersRepository(val context: Context) {
    private val retrofit = RetrofitHelper.getInstanceForGetRequest()
    var topSkllers: MutableLiveData<ArrayList<TopSkillers>> =
        MutableLiveData()
    var topLearners: MutableLiveData<ArrayList<TopLearners>> =
        MutableLiveData()

    fun getTopLearners(): LiveData<ArrayList<TopLearners>> {
        retrofit.create(TopLearnersApi::class.java)
            .getTopLearners().enqueue(object : Callback<ArrayList<TopLearners>> {
                override fun onFailure(call: Call<ArrayList<TopLearners>>, t: Throwable) {
                    Toast.makeText(context, "Check your connection", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<TopLearners>>,
                    response: Response<ArrayList<TopLearners>>
                ) {
                    if (!response.isSuccessful) {
                        Toast.makeText(context, "something went wrong", Toast.LENGTH_LONG).show()
                        return
                    }
                    topLearners.value = response.body()
                }
            })
        return topLearners
    }

    fun getTopSkillers(): LiveData<ArrayList<TopSkillers>> {
        retrofit.create(TopSkillersApi::class.java)
            .getTopSkillers().enqueue(object : Callback<ArrayList<TopSkillers>> {
                override fun onFailure(call: Call<ArrayList<TopSkillers>>, t: Throwable) {
                    Toast.makeText(context, "Check your connection", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<ArrayList<TopSkillers>>,
                    response: Response<ArrayList<TopSkillers>>
                ) {
                    if (!response.isSuccessful) {
                        Toast.makeText(context, "something went wrong", Toast.LENGTH_LONG).show()
                        return
                    }
                    topSkllers.value = response.body()
                }

            })
        return topSkllers
    }

}