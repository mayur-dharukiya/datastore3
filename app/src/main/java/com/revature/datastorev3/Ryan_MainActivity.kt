package com.revature.datastorev3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.revature.datastorev3.ui.theme.Datastore3Theme
import com.revature.datastorev3.ui.ui.Ryan_StoreUserEmail
import kotlinx.coroutines.launch

class Ryan_MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Datastore3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoginScreen_Ryan()
                }
            }
        }
    }
}

@Composable
fun LoginScreen_Ryan(){
     val context = LocalContext.current

    val scope = rememberCoroutineScope()

    val dataStore = Ryan_StoreUserEmail(context)

    Column(modifier = Modifier.wrapContentSize()) {
        var readEmail = dataStore.getEmail.collectAsState(initial = "").value
        var email by rememberSaveable { mutableStateOf("") }
        email = readEmail!!
        //
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "EMAIL",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        //email field
        TextField(
            value = email,
            onValueChange = { email = it },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType
                = KeyboardType.Email
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),

            )
        Spacer(modifier = Modifier.height(16.dp))

        //Password field
        var readPass = dataStore.getPassword.collectAsState(initial = "").value
        var pass by rememberSaveable { mutableStateOf("") }
        pass = readPass!!
        Text(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .alpha(0.6f),
            text = "PASSWORD",
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray,
            fontSize = 12.sp
        )
        TextField(
            value = pass!!,
            onValueChange = { pass = it },

            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType
                = KeyboardType.Password
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
                .fillMaxWidth(),

            )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                //launch the class in a coroutine scope
                scope.launch {
                    dataStore.saveEmail(email!!)
                    dataStore.savePassword(pass!!)
                }

            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(16.dp, 0.dp, 16.dp, 0.dp),
        ) {
            Text(
                style = MaterialTheme.typography.subtitle1,
                color = Color.White,
                text = "Save Account",

                )
        }
        Spacer(modifier = Modifier.height(32.dp))

        val userEmail = dataStore.getEmail.collectAsState(initial = "")

        Text(text = userEmail.value!!)

    }
}
@Preview
@Composable
fun RyanPreview(){
    LoginScreen_Ryan()
}