package com.revature.datastorev3.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences


class Micah_StoreUserEmail(private val context: Context) {


    // this make sure that we have one instance of this class
    //companion is equal to static in java
    companion object{

        val Context.myDataStoreObject:DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("userEmail")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email") //key name to retrive the data
    }

    //get email value from datastore

    val getEmail: Flow<String> = context.myDataStoreObject.data
        .map { preferences->
            preferences[USER_EMAIL_KEY]?:"FIRSTLAST@MAIL.COM"
        }

    //save email

    suspend fun saveEmail(name:String){
        context.myDataStoreObject.edit { preferences->

            preferences[USER_EMAIL_KEY]=name
        }
    }
}