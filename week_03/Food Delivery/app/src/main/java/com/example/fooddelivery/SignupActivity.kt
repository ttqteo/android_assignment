package com.example.fooddelivery

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.coroutineScope
import com.example.fooddelivery.databinding.ActivitySignupBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    lateinit var userManager: UserManager
    lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)

        userManager = UserManager(this)

        binding.buttonSignup.setOnClickListener{
            CoroutineScope(IO).launch {
                userManager.storeUser(
                    binding.edtName.text.toString().trim(),
                    binding.edtEmail.text.toString().trim(),
                    binding.edtPass.text.toString().trim()
                )
            }
        }

//        lifecycle.coroutineScope.launchWhenCreated {
//            userManager.getName().collect {
//                binding.id.text = it
//            }
//        }
    }

}