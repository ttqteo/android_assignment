package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val veriBtn = findViewById<Button>(R.id.btnVeri);
        veriBtn.setOnClickListener {
            val Intent = Intent(this, VerifyOtpActivity::class.java)
            startActivity(Intent)
        }
    }

}