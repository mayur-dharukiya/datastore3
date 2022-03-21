package com.revature.datastorev3

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import java.util.prefs.Preferences

class Sarah_StoreUserEmail
{
    companion object // Creating a companion object to make sure that we only have one instance of this class
    {
        private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("userEmail") // datastore file name
        val USER_EMAIL_KEY = stringPreferencesKey("user_email") // Key name to retrieve the data
    }
}