package com.judekwashie.leaderboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.judekwashie.leaderboard.adapters.TopSkillersRecyclerAdapter
import com.judekwashie.leaderboard.viewmodel.ApiViewModel
import kotlinx.android.synthetic.main.fragment_skill_iq_list.*
import kotlinx.android.synthetic.main.fragment_top_learner_list.*

class SkillIQListFragment : Fragment() {

    private lateinit var topSkillersAdapter: TopSkillersRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_skill_iq_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val apiViewModel = ApiViewModel(context!!)
        apiViewModel.getTopSkillers().observe(this, Observer {

            topSkillersAdapter = TopSkillersRecyclerAdapter(context!!, it)
            topSkillerRecyclerView.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = topSkillersAdapter
                isNestedScrollingEnabled = false
            }
            if(it.isNotEmpty()){
                progress_circular.visibility = View.GONE
            }
        })
    }

    override fun onStop() {
        super.onStop()
        progress_circular.visibility = View.GONE
    }
}