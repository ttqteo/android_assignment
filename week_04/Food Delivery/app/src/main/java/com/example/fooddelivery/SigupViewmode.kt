package com.example.fooddelivery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//enum class Error{
//    ERROR_EMAIL,
//    ERROR_PASSWORD,
//}
//class Resp(val isSuccess: Boolean, val error: Error?)
class SignupViewmode: ViewModel() {
    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    private var _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent

    fun checkEmailAndPassword(email: String, password: String) {
        //kiem tra format email
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("email không hợp lệ")
            return
        }
<<<<<<< HEAD
        //password length > 8 && < 10
        //password length > 8 && < 20
=======
        //password
>>>>>>> 0de40892d3688e2b98f19d0abe5530369aef8815
        val isValidPassword = isPasswordValid(password)
        if (!isValidPassword) {
//            _isErrorEvent.postValue("Password không hợp lệ")
            return
        }
        _isSuccessEvent.postValue(true)
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {

//        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()]){8,}$".toRegex())
        if(password.length < 8){
            _isErrorEvent.postValue("Password phải có ít nhất 8 ký tự")
            return false
        }else if(!password.matches(".*[a-z].*".toRegex())){
            _isErrorEvent.postValue("Password phải có ít nhất 1 chữ viết thường")
            return false
        }else if(!password.matches(".*[A-Z].*".toRegex())){
            _isErrorEvent.postValue("Password phải có ít nhất 1 chữ viết hoa")
            return false
        }
        else if(!password.matches(".*[0-9].*".toRegex())){
            _isErrorEvent.postValue("Password phải có ít nhất 1 ký tự số")
            return false
        }else if(!password.matches(".*[!@#$%^&*()].*".toRegex())){
            _isErrorEvent.postValue("Password phải có ít nhất 1 ký tự đặt biệt: !@#$%^&*()")
            return false
        }
        return true

//        return password.length in 8..20
    }
}