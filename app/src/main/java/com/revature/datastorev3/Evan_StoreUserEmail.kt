package com.revature.datastorev3

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringSetPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Evan_StoreUserEmail(private val context: Context) {

    //companion keyword - to make sure we have only one instance of this class

    companion object {

        private val Context.myDataStoreObject: DataStore<Preferences>
            by preferencesDataStore("userEmail")    //datastore file name
        val USER_EMAIL_KEY = stringSetPreferencesKey("user_email")  //key to retrieve the data

    }
    //get email value from datastore
    val getEmail: Flow<Any> = context.myDataStoreObject.data
        .map { preferences ->

            preferences[USER_EMAIL_KEY]?: "FIRSTLAST@GMAIL.COM"

        }

    //saving email
    suspend fun saveEmail(name:String) {

        context.myDataStoreObject.edit { preferences ->

            preferences[USER_EMAIL_KEY] = setOf(name)

        }
    }
}