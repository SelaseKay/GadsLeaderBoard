package com.judekwashie.leaderboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Fade
import android.view.View
import android.view.Window
import com.google.android.material.tabs.TabLayout
import com.judekwashie.leaderboard.adapters.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_skill_iq_list.*
import kotlinx.android.synthetic.main.recycler_view_toolbar.*

class LearnersListActivity : AppCompatActivity() {

    private lateinit var pageAdapter: PageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)

        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startFadeAnim()

        pageAdapter = PageAdapter(
            supportFragmentManager,
            tablayout.tabCount
        )
        viewPager.adapter = pageAdapter

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager.currentItem = tab.position
                }
            }

        })
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tablayout))

        submitButton.setOnClickListener {
            val intent = Intent(this, SubmitActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    private fun startFadeAnim() {
        val fadeAnimation = Fade()
        fadeAnimation.duration = 500
        window.enterTransition = fadeAnimation

    }

}