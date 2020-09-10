package com.judekwashie.leaderboard

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        Handler().postDelayed(Runnable
        {
            val i = Intent(this, LearnersListActivity::class.java)
            val options = ActivityOptions.makeSceneTransitionAnimation(this)
            i.putExtra("fadeAnim", "fadeAnim")
            startActivity(i, options.toBundle())
            finish()
        }, 1500
        )

    }
}