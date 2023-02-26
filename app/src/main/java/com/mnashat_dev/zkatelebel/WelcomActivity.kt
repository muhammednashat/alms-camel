package com.mnashat_dev.zkatelebel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class WelcomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        supportActionBar?.hide()
        Handler().postDelayed({
        startActivity(Intent(this@WelcomActivity,HomeActivity::class.java))
            finish()
        },3000)
    }
}