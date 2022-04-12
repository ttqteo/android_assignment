package com.example.fooddelivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fooddelivery.DataAccount


enum class Error {
    ERROR_EMAIL,
    ERROR_PASSWORD
}

class Resp(val isSuccess: Boolean, val error: Error?)

class ProfileModel : ViewModel() {

    private val _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    private val _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent

    fun checkEmail(email: String) {
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("Email không hợp lệ")
            return
        }
        _isSuccessEvent.postValue(true)
    }
    fun checkEmailAndPassword(email: String,password: String) {

        val isNotEmptyEmailAndPassword = isEmailAndPasswordNotEmpty(email,password)
        if(!isNotEmptyEmailAndPassword){
            _isErrorEvent.postValue("Enter your Email and password")
            return
        }
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("Email InValid")
            return
        }
        val isValidPassword = isPasswordValid(password)
        if(!isValidPassword) {
            _isErrorEvent.postValue("Password InValid")
            return
        }
//        val emailPasswordCorrect = correctEmailAndPassword(email, password)
//        if (!emailPasswordCorrect) {
////        if (!emailPasswordCorrect) {
//            _isErrorEvent.postValue("Incorrect Email or Password")
//            return
//        }
        if (email != DataAccount.getAccountInfo().email) {
            _isErrorEvent.postValue("Email không tồn tại")
            return
        }
        if (password != DataAccount.getAccountInfo().password) {
            _isErrorEvent.postValue("Password không đúng")
            return
        }
        _isSuccessEvent.postValue(true)


    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isPasswordValid(password : String ):Boolean{
        return password.length > 8
    }
    private fun isEmailAndPasswordNotEmpty(email: String,password: String):Boolean{
        val passwordNotEmpty = password.isNotEmpty()
        val emailNotEmpty = email.isNotEmpty()
        return passwordNotEmpty && emailNotEmpty
    }
    private fun correctEmailAndPassword(email: String,password: String): Boolean {
        return email == UserManager.USER_EMAIL_KEY && password ==UserManager.USER_PASS_KEY
    }
}