package com.example.fooddelivery

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val backBtn = findViewById<Button>(R.id.btnBack);
        backBtn.setOnClickListener {
            val Intent = Intent(this, MainActivity::class.java)
            startActivity(Intent)
        }

        val setName = findViewById<EditText>(R.id.editUsername).setOnClickListener {
            showDialog()
        }
        val setEmail = findViewById<EditText>(R.id.editTextTextEmailAddress).setOnClickListener {
            showDialog()
        }
        val setPhone = findViewById<EditText>(R.id.editTextPhone).setOnClickListener {
            showDialog()
        }


    }

    private fun showDialog() {
        val view : View = LayoutInflater.from(this).inflate(R.layout.layout_dialog, null)

        val editName = findViewById<EditText>(R.id.editUsername)
        val editMail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editPhone = findViewById<EditText>(R.id.editTextPhone)

        val textName = view.findViewById<EditText>(R.id.textFullName)
        textName.setText(editName.text.toString())
        val textEmail = view.findViewById<EditText>(R.id.textEmail)
        textEmail.setText(editMail.text.toString())
        val textPhoneNumber = view.findViewById<EditText>(R.id.textPhoneNumber)
        textPhoneNumber.setText(editPhone.text.toString())

        val builder = AlertDialog.Builder(this)
            .setView(view)
            .setTitle("Edit Information")

        builder.apply {
            setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                //get string
                val userName : String = textName.text.toString()
                val email : String = textEmail.text.toString()
                val phone : String = textPhoneNumber.text.toString()
                // set string
                editName.setText(userName)
                editMail.setText(email)
                editPhone.setText(phone)
            })
            setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->

            })
        }
        builder.show()
    }
}