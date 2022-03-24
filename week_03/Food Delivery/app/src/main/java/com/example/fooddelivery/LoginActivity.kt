package com.example.fooddelivery

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.databinding.ActivityLoginBinding
import java.text.Bidi

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var  viewModel: ProfileModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(ProfileModel::class.java)
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        //val bundle =Bundle()

        binding.buttonlogin.setOnClickListener {
            val email = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
            viewModel.checkEmailAndPassword(email, password)
        }
        listenerSuccessEvent()
        listenerErrorEvent()
    }



                  /*  if (binding.editUsername.text.toString() == "ronaldo@gmail.com" && binding.editPassword.editText.toString() == "123456") {


                        val builder = AlertDialog.Builder(this)
                        builder.apply {
                            title = "Android Alert"
                            setMessage("Log in successfully")
                            setNegativeButton(
                                "",
                                DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                                })
                        }
                        builder.show()

                    }
                    else
                    {
                        val builder = AlertDialog.Builder(this)
                        builder.apply {
                            title= "Android Alert"
                            setMessage("Wrong username or password")
                            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                            })
                        }
                        builder.show()
                    }
                }*/


    private fun listenerSuccessEvent() {
        viewModel.isSuccessEvent.observe(this) { isSucess ->
            if (isSucess) {
                val email = binding.editUsername.text.toString().trim()
                val password = binding.editPassword.text.toString().trim()
                val intent = Intent(this, ProfileActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            val builder = AlertDialog.Builder(this)
            builder.apply {
                title= "Android Alert"
                setMessage(errMsg)
                setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                })
            }
            builder.show()
        }
    }
}