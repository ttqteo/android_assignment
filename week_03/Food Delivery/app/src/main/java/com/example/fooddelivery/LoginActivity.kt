package com.example.fooddelivery

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnbackmain = findViewById<Button>(R.id.btn_back);
        btnbackmain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val editUsername = findViewById<EditText>(R.id.edit_username)
        val editPassword = findViewById<EditText>(R.id.edit_password)
        val username = editUsername.text.toString().trim()
        val password = editPassword.text.toString().trim()
        val btnlogin = findViewById<Button>(R.id.buttonlogin);
        btnlogin.setOnClickListener {

            if(editUsername.text.toString().isNotEmpty()&&editPassword.text.toString().isNotEmpty()) {
                if (editUsername.text.toString() == "ronaldo@gmail.com" && editPassword.text.toString() == "123456") {

                    val intent = Intent(this, ProfileActivity::class.java)
                    //val bundle = Bundle()
                    // bundle.putString("username", username)
                    //bundle.putString("password", password)
                    //intent2.putExtra("bundle", bundle)

                    val builder = AlertDialog.Builder(this)
                    builder.apply {
                        title = "Android Alert"
                        setMessage("Log in successfully")
                        setNegativeButton(
                            "OK",
                            DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                            })

                    }
                    builder.show()
                    startActivity(intent)
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
            }
            else
            {
                val builder = AlertDialog.Builder(this)
                builder.apply {
                    title= "Android Alert"
                    setMessage("Enter your username and password")
                    setNegativeButton("Cancel", DialogInterface.OnClickListener { dialogInterface: DialogInterface?, id: Int ->
                    })

                }
                builder.show()
            }
        }
    }

}