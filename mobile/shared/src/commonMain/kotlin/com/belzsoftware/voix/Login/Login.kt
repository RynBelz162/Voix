package com.belzsoftware.voix.login

import com.arkivanov.decompose.value.Value

interface Login {

    val models: Value<Model>

    fun onUsernameChanged(username: String)

    fun onPasswordChanged(password: String)

    fun onLogin()

    data class Model(
        val username: String,
        val password: String
    )
}