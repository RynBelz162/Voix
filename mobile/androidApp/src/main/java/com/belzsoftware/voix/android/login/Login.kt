package com.belzsoftware.voix.android.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Password
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material.icons.twotone.Visibility
import androidx.compose.material.icons.twotone.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.belzsoftware.voix.login.Login

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(component: Login)
{
    val state by component.models.subscribeAsState()

    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Surface {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxHeight()
                .padding(15.dp)
        ) {

            OutlinedTextField(
                value = state.username,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp),
                onValueChange = component::onUsernameChanged,
                label = {
                    Text(text = "Username")
                },
                leadingIcon = {
                    Icon(Icons.TwoTone.Person, contentDescription = "Username input icon")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            OutlinedTextField(
                value = state.password,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp),
                onValueChange = component::onPasswordChanged,
                label = {
                    Text(text = "Password")
                },
                leadingIcon = {
                    Icon(Icons.TwoTone.Password, contentDescription = "Password input icon")
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if(passwordVisible) Icons.TwoTone.Visibility else Icons.TwoTone.VisibilityOff
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(icon, contentDescription = description)
                    }
                }
            )
            Button(
                onClick = component::onLogin,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 5.dp),
            ) {
                Text(text = "Login")
            }
        }
    }
}
