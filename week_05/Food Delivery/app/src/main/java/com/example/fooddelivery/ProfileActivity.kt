package com.example.fooddelivery

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.fooddelivery.databinding.ActivityProfileBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_profile)
        binding.user = com.example.fooddelivery.User(UserManager.USER_NAME_KEY, UserManager.USER_EMAIL_KEY, UserManager.USER_PHONE_KEY)
        viewModel = ViewModelProvider(this).get(ProfileModel::class.java)

        binding.btnBack.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

//        binding.btnToRestaureant.setOnClickListener{
//            val Intent = Intent(this, RestaurantActivity::class.java)
//            startActivity(Intent)
//        }

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
                listenerSuccessEvent(textName.text.toString(),
                    textEmail.text.toString(),
                    textPhoneNumber.text.toString()
                )
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
        UserManager.USER_EMAIL_KEY = email
        UserManager.USER_NAME_KEY = name
        UserManager.USER_PHONE_KEY = phone
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