package com.revature.datastorev3

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Evan_StoreUserEmail(private val context: Context) {

    //companion keyword - to make sure we have only one instance of this class

    companion object {

        private val Context.myDataStoreObject: DataStore<androidx.datastore.preferences.core.Preferences>
            by preferencesDataStore("UserDataFile") //datastore file name
        val USER_EMAIL_KEY= stringPreferencesKey("user_email") //key name to retrieve the data
        private val Context.myPasswordStoreObject: DataStore<androidx.datastore.preferences.core.Preferences>
            by preferencesDataStore("UserPasswordFile")
        val USER_PASSWORD_KEY = stringPreferencesKey("user_password")
    }
    //get email value from datastore
    val getEmail: Flow<String?> = context.myDataStoreObject.data
        .map { preferences->

            preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"
        }
    //save email
    suspend fun saveEmail(name:String) {

        context.myDataStoreObject.edit { preferences->

            preferences[USER_EMAIL_KEY] = name

        }
    }
    //get password value from datastore
    val getPassword: Flow<String?> = context.myPasswordStoreObject.data
        .map { preferences ->

            preferences[USER_PASSWORD_KEY]?: "PASSWORD"
        }

    //saving password
    suspend fun savePassword(name:String) {

        context.myPasswordStoreObject.edit { preferences ->

            preferences[USER_PASSWORD_KEY] = name
        }
    }
}