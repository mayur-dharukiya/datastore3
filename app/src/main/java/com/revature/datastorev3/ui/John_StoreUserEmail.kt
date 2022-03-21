package com.revature.datastorev3.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class John_StoreUserEmail (private val context:Context){

    companion object {

        private val Context.myDataStoreObject: DataStore<Preferences> by preferencesDataStore("userDataFile")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
    }

    //get email value from datastore

    val getEmail: Flow<String?> = context.myDataStoreObject.data
        .map { preferences->

            preferences[Mayur_StoreUserEmail.USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"
        }

    //save email

    suspend fun saveEmail(name:String)
    {
        context.myDataStoreObject.edit { preferences->

            preferences[Mayur_StoreUserEmail.USER_EMAIL_KEY]=name

        }
    }
}