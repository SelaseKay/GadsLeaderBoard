package com.judekwashie.leaderboard.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.judekwashie.leaderboard.LearnersListFragment
import com.judekwashie.leaderboard.SkillIQListFragment

class PageAdapter(fragmentManager: FragmentManager, private val numOfTabs: Int) :
    FragmentStatePagerAdapter(fragmentManager, numOfTabs) {
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> LearnersListFragment()
            else -> SkillIQListFragment()
        }
    }

    override fun getCount(): Int {
        return numOfTabs
    }

}