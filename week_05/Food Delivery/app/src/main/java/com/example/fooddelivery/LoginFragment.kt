package com.example.fooddelivery

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.databinding.FragmentLoginBinding
import com.example.fooddelivery.databinding.FragmentWelcomeBinding
import androidx.navigation.fragment.findNavController


class LoginFragment : Fragment() {


    lateinit var binding : FragmentLoginBinding
    private lateinit var  viewModel: ProfileModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ProfileModel::class.java)
        binding.btnBack.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_loginFragment_to_mainFragment)
        }
        binding.textView4.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_loginFragment_to_signupFragment)
        }
        binding.buttonlogin.setOnClickListener {
            val email = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            viewModel.checkEmailAndPassword(email, password)
        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }

    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(viewLifecycleOwner) { isSucess ->
            if (isSucess) {

                val email = binding.editUsername.text.toString().trim()
                val password = binding.editPassword.text.toString().trim()

                val controller = findNavController()
                // controller.navigate(R.id.action_loginFragment_to_profileFragment)
            }
        }
    }
    private fun listenerErrorEvent() {
//        viewModel.isErrorEvent.observe(viewLifecycleOwner) { errMsg ->
//            val builder = AlertDialog.Builder(this)
//            builder.apply {
//                var title = "Android Alert"
//                setMessage(errMsg)
//                setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
//                })
//            }
//            builder.show()
//        }
    }



}