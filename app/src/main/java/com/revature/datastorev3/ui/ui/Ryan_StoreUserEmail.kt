package com.revature.datastorev3.ui.ui

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

class Ryan_StoreUserEmail(private val context:Context) {

    companion object{
        private val Context.dataStore: DataStore<androidx.datastore.preferences.core.Preferences> by preferencesDataStore("userEmail")
        val USER_EMAIL_KEY = stringPreferencesKey("user_email")
    }
}