package com.yash.weather

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreem : AppCompatActivity() {
    var handler=Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screem)
        handler.postDelayed(Runnable { startActivity(Intent(this,MainActivity::class.java))
            finish() }
            ,5000)
    }
}