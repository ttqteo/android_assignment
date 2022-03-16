package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class OnBoardingOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding_one)
        val button = findViewById<ImageView>(R.id.imageView17)
        button.setOnClickListener {
            val intent = Intent(this, OnBoardingTwoActivity::class.java)
            startActivity(intent)
        }

    }
}