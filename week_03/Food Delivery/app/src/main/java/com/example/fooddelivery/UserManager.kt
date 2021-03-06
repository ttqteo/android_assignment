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
        //val USER_NAME_KEY = stringPreferencesKey("USER_NAME")
        //val USER_EMAIL_KEY = stringPreferencesKey("USER_EMAIL")
        //val USER_PASS_KEY = stringPreferencesKey("USER_PASS")
        var USER_NAME_KEY = toString()
        var USER_EMAIL_KEY = toString()
        var USER_PASS_KEY = toString()
        var USER_PHONE_KEY = toString()

    }

    suspend fun storeUser(name: String, email: String, pass: String){
        context.dataStore.edit {
            //it[USER_NAME_KEY] = name
            //it[USER_EMAIL_KEY] = email
            //it[USER_PASS_KEY] = pass
            USER_NAME_KEY = name
            USER_EMAIL_KEY = email
            USER_PASS_KEY = pass
            USER_PHONE_KEY = "0366677885"
        }
    }

   /* public final fun getName() = context.dataStore.data.map {
        it[USER_NAME_KEY]?:""
    }

    public final fun getEmail() = context.dataStore.data.map {
        it[USER_EMAIL_KEY]?:""
    }

    public final fun getPass() = context.dataStore.data.map {
        it[USER_PASS_KEY]?:""
    }*/
}