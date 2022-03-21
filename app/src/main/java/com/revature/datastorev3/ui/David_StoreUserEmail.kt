package com.revature.datastorev3.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class David_StoreUserEmail(private val context: Context) {


    // To make sure that we have only one instance of this class

    companion object {

        private val Context.myDataStoreObject: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("userEmailFile")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email") // key name to retrieve the data
    }

    //get email value from datastore

    val getEmail: Flow<String?> = context.myDataStoreObject.data
        .map{ preferences ->

            preferences[USER_EMAIL_KEY]?: "FIRSTLAST@GMAIL.COM"

        }

    //save email

    suspend fun saveEmail(name: String)
    {
        context.myDataStoreObject.edit { preferences ->

            preferences[USER_EMAIL_KEY] = name

        }
    }

}