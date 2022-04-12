package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentOnBoardingTwoBinding
import com.example.fooddelivery.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {
    lateinit var binding : FragmentWelcomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcomeBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcomeStartWith.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_welcomeFragment_to_signupFragment)
        }
        binding.welcomeSignIn.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_welcomeFragment_to_loginFragment)
        }
        binding.welcomeSkip.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_welcomeFragment_to_restaurantFragment)
        }
    }

}