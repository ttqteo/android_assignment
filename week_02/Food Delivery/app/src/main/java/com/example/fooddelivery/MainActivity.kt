package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            var intent = Intent(this, OnBoardingOneActivity::class.java)
            startActivity(intent)
        }, 2000)

//        val profileBtn = findViewById<Button>(R.id.btnProfile);
//        profileBtn.setOnClickListener {
//            val Intent = Intent(this, ProfileActivity::class.java)
//            startActivity(Intent)
//        }

//        val welBtn = findViewById<Button>(R.id.btnWelcome);
//        welBtn.setOnClickListener {
//            val Intent = Intent(this, WelcomeActivity::class.java)
//            startActivity(Intent)
//        }
//
//        val singupBtn = findViewById<Button>(R.id.btnSignUp);
//        singupBtn.setOnClickListener {
//            val Intent = Intent(this, SignupActivity::class.java)
//            startActivity(Intent)
//        }
//
//        val onBoardingOneBtn = findViewById<Button>(R.id.btnOnBoOne);
//        onBoardingOneBtn.setOnClickListener {
//            val Intent = Intent(this, OnBoardingOneActivity::class.java)
//            startActivity(Intent)
//        }
//
//        val loginBtn = findViewById<Button>(R.id.btnLogIn);
//        loginBtn.setOnClickListener {
//            val Intent = Intent(this, LoginActivity::class.java)
//            startActivity(Intent)
//        }
//
//        val veriBtn = findViewById<Button>(R.id.btnVeri);
//        veriBtn.setOnClickListener {
//            val Intent = Intent(this, VerifyOtpActivity::class.java)
//            startActivity(Intent)
//        }
    }

}