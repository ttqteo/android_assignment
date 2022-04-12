package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        val btskip = findViewById<Button>(R.id.welcome_skip)
        btskip.setOnClickListener{
//            val Intent = Intent(this, RestaurantActivity::class.java)
//            startActivity(Intent)
        }
        val btsignin = findViewById<TextView>(R.id.welcome_sign_in)
        btsignin.setOnClickListener{
            val Intent1 = Intent(this, LoginActivity::class.java)
            startActivity(Intent1)
        }
        val btsignup = findViewById<Button>(R.id.welcome_start_with)
        btsignup.setOnClickListener {
          //  val Intent2 = Intent(this, SignupActivity::class.java)
           // startActivity(Intent2)
        }

    }
}