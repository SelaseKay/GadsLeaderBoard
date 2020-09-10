package com.judekwashie.leaderboard.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.judekwashie.leaderboard.repo.LearnersRepository

class ApiViewModel(context: Context) : ViewModel() {
    private val repository: LearnersRepository = LearnersRepository(context)

    fun getTopSkillers() = repository.getTopSkillers()
    fun getTopLearners() = repository.getTopLearners()

}