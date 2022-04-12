package com.example.fooddelivery

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map



class UserManager(val context: Context) {

    val Context.dataStore : DataStore<Preferences> by preferencesDataStore("user_prefs")

    companion object{

        var USER_NAME_KEY = toString()
        var USER_EMAIL_KEY = toString()
        var USER_PASS_KEY = toString()
        var USER_PHONE_KEY = toString()

    }

    fun storeUser(name: String, email: String, pass: String)
         {
            USER_NAME_KEY = name
            USER_EMAIL_KEY = email
            USER_PASS_KEY = pass
            USER_PHONE_KEY = "0366677885"
        }



}