package com.example.fooddelivery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class RestaurantActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        DataStore.getDataRestaurant(this@RestaurantActivity);
    }
}