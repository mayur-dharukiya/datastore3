package com.revature.datastorev3.ui
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Brandon_StoreUserEmail(private val context: Context) {

    //to make sure we only have one instance, make companion object
    companion object {
        private val Context.myDataStoreObject: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("userEmail")
        val USER_EMAIL_KEY= stringPreferencesKey("user_email")                                          //store data under filename userEmail
    }

    //retrieve email/value from datastore
    val getEmail: Flow<String?> = context.myDataStoreObject.data
            .map { preferences->
                preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"
            }

    //save email
    suspend fun saveEmail(name:String) {
        context.myDataStoreObject.edit { preferences->
            preferences[USER_EMAIL_KEY]=name
        }
    }
}