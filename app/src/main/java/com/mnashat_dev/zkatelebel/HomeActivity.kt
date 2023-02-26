package com.mnashat_dev.zkatelebel

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        findViewById<ImageView>(R.id.image_view).setOnClickListener {
            startActivity(Intent(this, CalculatingActivity::class.java))
        }
    }
}