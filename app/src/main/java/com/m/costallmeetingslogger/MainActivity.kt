package com.m.costallmeetingslogger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.m.costallmeetingslogger.R
import com.m.costallmeetingslogger.activities.AuthActivity
import com.m.costallmeetingslogger.activities.SplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        finish()
        startActivity(Intent(this,SplashScreen::class.java))
    }
}