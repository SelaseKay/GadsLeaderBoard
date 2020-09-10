package com.judekwashie.leaderboard.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.judekwashie.leaderboard.R
import com.judekwashie.leaderboard.adapters.TopLearnersRecyclerAdapter
import com.judekwashie.leaderboard.viewmodel.ApiViewModel
import kotlinx.android.synthetic.main.fragment_top_learner_list.*

class LearnersListFragment : Fragment() {

    private lateinit var topLearnerAdapter: TopLearnersRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_top_learner_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val apiViewModel = ApiViewModel(context!!)
        apiViewModel.getTopLearners().observe(this, Observer {
            topLearnerAdapter = TopLearnersRecyclerAdapter(context!!, it)
            topLearnerRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = topLearnerAdapter
                isNestedScrollingEnabled = false
            }
            progress_circular_2.visibility = View.GONE
        })

    }

    override fun onStop() {
        super.onStop()
        progress_circular_2.visibility = View.GONE
    }


}