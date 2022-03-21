package com.revature.datastorev3.ui.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class Richard_StoreUserEmail (private val context: Context) {

    //to make sure we only have one instance of this class

    companion object {
        private val Context.myDataStoreObject: DataStore<androidx
        .datastore
        .preferences
        .core
        .Preferences>
        by preferencesDataStore("userEmail")//specific name by which data is stored
        val USER_EMAIL_KEY = stringPreferencesKey("user_email") //key name to retrieve the data
    }

    //get email value from datastore

    val getEmail: Flow<String?> = context.myDataStoreObject.data
        .map { preferences->

            preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"

        }

    //save email

    suspend fun saveEmail(name: String)
    {
        context.myDataStoreObject.edit { preferences ->

            preferences[USER_EMAIL_KEY] = name
        }
    }

}