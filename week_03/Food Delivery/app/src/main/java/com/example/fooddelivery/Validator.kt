package com.example.fooddelivery

class Validator {
    companion object{
        fun isEmailValid(email:String):Boolean{
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
        fun isPasswordInvalid(password:String):Boolean {
            return password.length in 8..10
        }
    }
}