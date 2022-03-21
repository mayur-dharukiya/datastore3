package com.revature.datastorev3

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

class Sarah_StoreUserEmail(private val context: Context)
{
    companion object // Creating a companion object to make sure that we only have one instance of this class
    {
        private val Context.myDataStoreObject: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("userEmail") // datastore file name
        val USER_EMAIL_KEY = stringPreferencesKey("user_email") // Key name to retrieve the data
    }

    // Get email value from datastore
    val getEmail: Flow<String?> = context.myDataStoreObject.data
        .map {preferences -> preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"}

    // Save email
    suspend fun saveEmail(name: String)
    {
        context.myDataStoreObject.edit{preferences -> preferences[USER_EMAIL_KEY] = name}
    }
}