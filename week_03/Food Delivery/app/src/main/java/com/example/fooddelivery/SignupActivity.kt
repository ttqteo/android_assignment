package com.example.fooddelivery

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import com.example.fooddelivery.databinding.ActivitySignupBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SignupActivity : AppCompatActivity() {

    lateinit var userManager: UserManager
    lateinit var binding: ActivitySignupBinding
    lateinit var ViewModel: SignupViewmode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_signup)
        ViewModel= ViewModelProvider(this).get(SignupViewmode::class.java)
        userManager = UserManager(this)

//        binding.buttonSignup.setOnClickListener{
//            CoroutineScope(IO).launch {
//                userManager.storeUser(
//                    binding.edtName.text.toString().trim(),
//                    binding.edtEmail.text.toString().trim(),
//                    binding.edtPass.text.toString().trim()
//                )
//            }
//        }
        binding.textView5.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        binding.buttonSignup.setOnClickListener{
            val email=binding.edtEmail.text.toString().trim()
            val password=binding.edtPass.text.toString().trim()
            ViewModel.checkEmailAndPassword(email,password)
        }
        listennerSuccessEvent()
        listennerErrorEvent()

//        lifecycle.coroutineScope.launchWhenCreated {
//            userManager.getName().collect {
//                binding.id.text = it
//            }
//        }


    }
    private fun listennerSuccessEvent(){
        ViewModel.isSuccessEvent.observe(this){ isSuccess->
            if(isSuccess){
                val intent=Intent(this, LoginActivity::class.java)
                CoroutineScope(IO).launch {
                    userManager.storeUser(
                        binding.edtName.text.toString().trim(),
                        binding.edtEmail.text.toString().trim(),
                        binding.edtPass.text.toString().trim()
                    )
                }
                startActivity(intent)
            }
        }
    }
    private fun listennerErrorEvent(){
        ViewModel.isErrorEvent.observe(this){errMsg ->
            Toast.makeText( this,errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}