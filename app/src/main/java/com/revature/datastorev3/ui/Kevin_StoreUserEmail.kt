package com.revature.datastorev3.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Kevin_StoreUserEmail(private val context:Context) {

    companion object{
        private val Context.myDataStore: DataStore<Preferences> by preferencesDataStore("userDataFile")
        val USER_EMAIL_KEY= stringPreferencesKey("user_email") //key name to retrieve data
    }
    val getEmail: Flow<String?> =context.myDataStore.data
        .map{preferences->
            preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM" // this allows a return or a default email to be returned
        }

    //save email
    suspend fun saveEmail(name:String)
    {
        context.myDataStore.edit { preferences->
            preferences[USER_EMAIL_KEY]=name
        }
    }
}