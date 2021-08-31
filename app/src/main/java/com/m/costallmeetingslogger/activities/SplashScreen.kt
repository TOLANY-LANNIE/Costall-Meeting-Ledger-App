package com.m.costallmeetingslogger.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.os.postDelayed
import com.m.costallmeetingslogger.MainActivity

import com.m.costallmeetingslogger.R

class SplashScreen : AppCompatActivity() {
    //variable used for the animation
    private lateinit var topAnim: Animation
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        //to disable the toolbar in splash screen
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)
        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)

        //Hooks
        image = findViewById(R.id.logo)
        //set animation
        image.animation = topAnim
        Handler().postDelayed({
            val intent=Intent(this@SplashScreen, MainActivity::class.java)
            startActivity(intent)
        }, SPLASH_TIME_OUT.toLong())
    }

    companion object {
        private const val SPLASH_TIME_OUT = 5000
    }
}