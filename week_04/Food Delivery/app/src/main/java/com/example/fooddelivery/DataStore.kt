package com.example.fooddelivery

import android.content.Context
import android.os.Environment
import android.util.Log
import com.example.fooddelivery.model.RestaurantModel
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

object DataStore {
    fun getDataRestaurant(context: Context): List<RestaurantModel> {
        val file = File(context.filesDir, "db_restaunrant.jl")
        val TAG = "MyActivity"
        val contents = FileInputStream(file).bufferedReader().use {
            Log.i("test",it.readLine())
        }
        return listOf(
            RestaurantModel(1, "abc", "bcd", "cad")
        )
    }
}