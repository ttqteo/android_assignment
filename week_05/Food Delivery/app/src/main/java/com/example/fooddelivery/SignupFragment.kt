package com.example.fooddelivery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.fooddelivery.databinding.FragmentSignupBinding
import com.example.fooddelivery.DataAccount
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.widget.Toast
import androidx.datastore.dataStore

class SignupFragment : Fragment() {

    lateinit var userManager: UserManager
    lateinit var ViewModel: SignupViewmode
    lateinit var binding : FragmentSignupBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ViewModel= ViewModelProvider(this).get(SignupViewmode::class.java)
       // userManager = UserManager(this)

    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        return binding.root
    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView5.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_signupFragment_to_loginFragment)
        }
        binding.buttonSignup.setOnClickListener {
            val email=binding.edtEmail.text.toString().trim()
            val password=binding.edtPass.text.toString().trim()
            ViewModel.checkEmailAndPassword(email,password)
        }
        listennerSuccessEvent()
        listennerErrorEvent()

    }
    private fun listennerSuccessEvent(){
        ViewModel.isSuccessEvent.observe(viewLifecycleOwner){ isSuccess->
            if(isSuccess){


//                    userManager.storeUser(
//                        binding.edtName.text.toString().trim(),
//                        binding.edtEmail.text.toString().trim(),
//                        binding.edtPass.text.toString().trim()
//                    )

                DataAccount.createAccount(
                    binding.edtName.text.toString().trim(),
                    binding.edtEmail.text.toString().trim(),
                    binding.edtPass.text.toString().trim()
                )


                val controller = findNavController()
                controller.navigate(R.id.action_signupFragment_to_loginFragment)
            }
        }
    }
    private fun listennerErrorEvent(){
        ViewModel.isErrorEvent.observe(viewLifecycleOwner){errMsg ->
            Toast.makeText( this@SignupFragment.requireContext(),errMsg,Toast.LENGTH_SHORT).show()
        }
    }

}