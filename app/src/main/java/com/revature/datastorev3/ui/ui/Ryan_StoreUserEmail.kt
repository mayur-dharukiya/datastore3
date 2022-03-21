package com.revature.datastorev3.ui.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Ryan_StoreUserEmail(private val context:Context) {

    companion object{
        private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences>
        by preferencesDataStore("userEmail")

        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
    }

    //get email
    val getEmail: Flow<String?> = context.dataStore.data
        .map{
            it[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"
        }

    //save email
    suspend fun saveEmail(name:String){
        context.dataStore.edit {
            it[USER_EMAIL_KEY]=name
        }
    }
}