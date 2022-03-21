package com.revature.datastorev3.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


//This file is the data storage initialization class file

class Lyle_StoreUserEmail(private val context: Context) {

    //to make sure we only have one instance of this class (make the companion object): companion=Static in Java

    companion object{
        private val Context.myDataStoreObject:DataStore<Preferences> by preferencesDataStore("FileNameStorage")//datastore file name
        var USER_EMAIL_KEY= stringPreferencesKey("user_email")//key name to retrieve the data

    }

    //create a function to initialize and get the email from datastore
    val getEmail: Flow<String?> = context.myDataStoreObject.data
        .map{ preferences->

            //default key that will get replaced
            preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"
        }

    //create a function to save the email(this function can be copied to be able to store other types of data)
    suspend fun saveEmail(name:String){
        context.myDataStoreObject.edit{ preferences->

            preferences[USER_EMAIL_KEY]=name

        }
    }

}