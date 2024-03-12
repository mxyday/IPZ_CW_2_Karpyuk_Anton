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
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role.Companion.Button
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
    Column(
        var signInState by remember { mutableStateOf<SignInState>(SignInState.SignIn) }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        modifier = Modifier
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = { onEmailChange(it) },
        )
        OutlinedTextField(
            value = "",
            onValueChange = { onPasswordChange(it) },
            )
        )
        Button(onClick = { onSignInClick() }) {
            Text("Sign In")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    IPZ_CW_2_Karpyuk_AntonTheme {
        SignInCard("")
    }
}