package com.revature.datastorev3.ui.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class Gale_StoreUserEmail(private val context: Context) {

    //to make sure we only have instance
    companion object{

        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userEmail")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")//key name to retrieve the data

    }

    //get email value from datastore
    var getEmail: Flow<String> = context.dataStore.data.map{
        preferences ->
        preferences[USER_EMAIL_KEY]?: "FIRSTLAST@GMAIL.COM"
    }

    //save email
    suspend fun saveEmail(name:String){

        context.dataStore.edit{ preferences ->

            preferences[USER_EMAIL_KEY] = name


        }
    }
}