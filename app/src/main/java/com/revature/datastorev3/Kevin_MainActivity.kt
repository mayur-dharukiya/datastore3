package com.revature.datastorev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.revature.datastorev3.ui.Kevin_StoreUserEmail
import com.revature.datastorev3.ui.theme.Datastore3Theme

class Kevin_MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Datastore3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen_Kevin()
                }
            }
        }
    }
}
@Composable
fun LoginScreen_Kevin()
{
    val context= LocalContext.current

    val scope= rememberCoroutineScope()

    val dataStore= Kevin_StoreUserEmail(context)



}