package com.connor.composedemo.onboarding.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.connor.composedemo.R
import com.connor.composedemo.destinations.view.DestinationsActivity
import com.connor.composedemo.ui.utils.AppButton
import com.connor.composedemo.ui.utils.AppField

class LoginActivity : ComponentActivity() {

    //todo clean up
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val openDialog = remember { mutableStateOf(false)  }

            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(Modifier.weight(1f)) {
                    ComposeLoginTitle()
                }

                val emailFieldState = remember { mutableStateOf(TextFieldValue()) }
                val passwordFieldState = remember { mutableStateOf(TextFieldValue()) }

                AppField(
                    modifier = Modifier.padding(
                        start = 0.dp,
                        top = 0.dp,
                        end = 0.dp,
                        bottom = 16.dp
                    ),
                    placeholder = stringResource(id = R.string.login_email_placeholder),
                    fieldValue = emailFieldState
                )
                AppField(
                    placeholder = stringResource(id = R.string.login_password_placeholder),
                    password = true
                )
                AppButton(
                    buttonText = stringResource(id = R.string.login_screen_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    if (isValidatedEmail(emailFieldState.value.text)) {
                        startActivity(Intent(context, DestinationsActivity::class.java))
                    } else {
                        openDialog.value = true
                    }
                }

                //i find this whole mutable state logic messy
                if (openDialog.value) {
                    ComposeError(openDialog)
                }
            }
        }
    }

    @Composable
    fun ComposeLoginTitle() {
        Text(
            text = stringResource(id = R.string.login_screen_title),
            fontSize = 20.sp,
            color = MaterialTheme.colors.primary,
            modifier = Modifier.padding(16.dp)
        )
    }

    //This would obviously not go in the view!
    private fun isValidatedEmail(email: String): Boolean {
        if (email != "connor@test.com") {
            return false
        }

        return true
    }

    @Composable
    private fun ComposeError(state: MutableState<Boolean>) {
        AlertDialog(
            onDismissRequest = {
//                // Dismiss the dialog when the user clicks outside the dialog or on the back
//                // button. If you want to disable that functionality, simply use an empty
//                // onCloseRequest.
                state.value = false
            },
            title = {
                Text(text = "Uh oh")
            },
            text = {
                Text("The only valid email is connor@test.com. Use that, or forever be stuck on this Log In screen!")
            },
            confirmButton = {
                Button(

                    onClick = {
                        state.value = false
                    }) {
                    Text("That's weird, but ok")
                }
            }
        )
    }
}