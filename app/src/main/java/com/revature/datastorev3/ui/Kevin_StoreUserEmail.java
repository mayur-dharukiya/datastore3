package com.revature.datastorev3.ui;

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.prefs.Preferences

public class Kevin_StoreUserEmail(private val context:Context) {

    companion object {

        private val Context.myDataStoreOjbect: DataStore<Preferences> by preferencesDataStore("UserDataFile")
        val USER_EMAIL_KEY=stringPreferencesKey("user_email")  //keyname to retrieve data
    }
    //get email value from datastore

    val getEmail: Flow<String?>=context.myDataStoreObject.data
        .map { preferences->

            preferences[USER_EMAIL_KEY]?:"FIRSTLAST@GMAIL.COM"
    }
    //save email

    suspend fun saveEmail(name:String)
    {
        context.myDataStoreObject.edit { preferences->

            preferences[USER_EMAIL_KEY]=name
        }
    }

}
