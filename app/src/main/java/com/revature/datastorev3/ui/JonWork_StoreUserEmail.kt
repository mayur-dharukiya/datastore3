package com.revature.datastorev3.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class JonWork_StoreUserEmail(private val context: Context) {
    companion object{
        private val Context.dataStoree:DataStore<Preferences> by preferencesDataStore("Email")
        val USER_EMAIL_KEY= stringPreferencesKey("user_email")
    }
    val getEmail: Flow<String> =context.dataStoree.data.map { preferences->
        preferences[USER_EMAIL_KEY]?:"FIRSTLAST@gmail.com"
    }
    suspend fun saveEmail(name:String)
    {
        context.dataStoree.edit { preferences->
            preferences[USER_EMAIL_KEY]=name
        }
    }

}