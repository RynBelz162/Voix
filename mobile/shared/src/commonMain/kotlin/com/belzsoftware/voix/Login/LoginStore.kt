package com.belzsoftware.voix.Login

import com.arkivanov.mvikotlin.core.store.Store
import com.belzsoftware.voix.Login.LoginStore.Intent
import com.belzsoftware.voix.Login.LoginStore.State

internal interface LoginStore : Store<Intent, State, Nothing> {
    sealed class Intent {
        data class Login(val username: String, val password: String): Intent()
    }

    data class State(
        val username: String = "",
        val password: String = ""
    )
}