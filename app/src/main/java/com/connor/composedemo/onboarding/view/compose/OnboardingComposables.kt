package com.connor.composedemo.onboarding.view.compose

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

//todo Reusable button?
@Composable
fun RegisterButton() {
    Button(onClick = { /* Do something! */ }, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Red
    )) {
        //todo resources?
        Text("Get Started")
    }
}

@Composable
fun LoginButton(clickListener: () -> Unit) {
    Button(clickListener, colors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Blue
    )) {
        Text("I already have an account")
    }
}