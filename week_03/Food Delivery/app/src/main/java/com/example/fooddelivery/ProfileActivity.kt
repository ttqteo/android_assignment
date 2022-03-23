package com.example.fooddelivery

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.user = com.example.fooddelivery.User("Tran Tu Quang", "ronaldo@gmail.com", "987654366")
        viewModel = ViewModelProvider(this).get(ProfileModel::class.java)

        binding.btnBack.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        binding.editProfile.setOnClickListener({ showDialog() })

    }


    private fun showDialog() {

        val layoutDialog : View = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null)
        val textName = layoutDialog.findViewById<EditText>(R.id.textFullName)
        textName.setText(binding.editUsername.text.toString())
        val textEmail = layoutDialog.findViewById<EditText>(R.id.textEmail)
        textEmail.setText(binding.edtEmail.text.toString())
        val textPhoneNumber = layoutDialog.findViewById<EditText>(R.id.textPhoneNumber)
        textPhoneNumber.setText(binding.editTextPhone.text.toString())

        val builder = AlertDialog.Builder(this)
            .setView(layoutDialog)
            .setTitle("Edit Information")

        builder.apply {
            setPositiveButton("Change", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                viewModel.checkEmail(textEmail.text.toString())
                listenerSuccessEvent(textName.text.toString(), textEmail.text.toString(), textPhoneNumber.text.toString())
                listenerErrorEvent()

            })
            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->

            })
        }
        builder.show()
    }

    private fun listenerSuccessEvent(name: String, email:String, phone:String) {
        viewModel.isSuccessEvent.observe(this) { isSucess ->
            if (isSucess) {
                binding.user = com.example.fooddelivery.User(name, email, phone)
            }
        }
    }
    private fun listenerErrorEvent() {
        viewModel.isErrorEvent.observe(this) { errMsg ->
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Lỗi")
            dialog.setMessage(errMsg)
            dialog.show()
//            Toast.makeText(this, errMsg, Toast.LENGTH_SHORT).show()
        }
    }
}