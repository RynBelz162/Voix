package com.belzsoftware.voix.android.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.belzsoftware.voix.android.styling.AppTheme
import com.belzsoftware.voix.login.Login

@Preview(widthDp = 340, name = "340 width - Me")
@Composable
fun LoginPreview340()
{
    AppTheme {
        LoginScreen(LoginPreview())
    }
}

class LoginPreview : Login {
    override val models: Value<Login.Model> =
        MutableValue(
            Login.Model(
                username = "",
                password = ""
            )
        )

    override fun onUsernameChanged(username: String) {}
    override fun onPasswordChanged(password: String) {}
    override fun onLogin() {}
}