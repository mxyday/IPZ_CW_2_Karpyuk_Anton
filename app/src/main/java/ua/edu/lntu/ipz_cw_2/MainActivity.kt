package ua.edu.lntu.ipz_cw_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import ua.edu.lntu.ipz_cw_2.ui.theme.IPZ_CW_2_Karpyuk_AntonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CW_2_Karpyuk_AntonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignInCard("")
                }
            }
        }
    }
}

@Composable
fun SignInCard(name: String, modifier: Modifier = Modifier) {
    var signInTrue by remember { mutableStateOf(false) }
    var email by remember { mutableStateOf(TextFieldValue()) }
    var password by remember { mutableStateOf(TextFieldValue()) }

    if (!signInTrue) {
        Column(
            modifier = Modifier
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = { email = it },
            )
            OutlinedTextField(
                value = "",
                onValueChange = { password = it },
            )
            Button(onClick = {
                if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
                    signInTrue = true
                }
            }) {
                Text("Sign In")
            }
        }
    }
    else {
        Text(
            text = "Sign in successful"
        )
        Button(onClick = {
            signInTrue = false
            email = TextFieldValue()
            password = TextFieldValue()
        }) {
            Text("Sign Out")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignInPreview() {
    IPZ_CW_2_Karpyuk_AntonTheme {
        SignInCard("")
    }
}