package com.example.movieapp.screens.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.fragment.PlayingFragment
import com.example.movieapp.fragment.RateFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val playingFragment = PlayingFragment()
    private val rateFragment = RateFragment()


    private lateinit var bottomNavView: BottomNavigationView
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        bottomNavView = binding.botNav

        replaceFragment(playingFragment)
        bottomNavView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.play_bot -> replaceFragment(playingFragment)
                R.id.rate_bot -> replaceFragment(rateFragment)

            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
    }
}