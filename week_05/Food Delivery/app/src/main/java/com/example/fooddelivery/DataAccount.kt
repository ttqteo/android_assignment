package com.example.fooddelivery

object DataAccount {

    private lateinit var myAccount: UserAccount

    fun createAccount(name: String, email: String, password: String, phone: String = "") {
        myAccount = UserAccount(name, email, password, phone)
    }

    fun getAccountInfo(): UserAccount {
        return myAccount
    }

    fun editAccount(name: String, email: String, password: String, phone: String) {
        myAccount.name = name
        myAccount.email = email
        myAccount.phone = phone
    }

}