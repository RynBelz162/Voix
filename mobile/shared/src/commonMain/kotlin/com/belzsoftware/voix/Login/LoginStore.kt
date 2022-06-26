package com.belzsoftware.voix.login

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.core.utils.ExperimentalMviKotlinApi
import com.arkivanov.mvikotlin.extensions.coroutines.coroutineExecutorFactory

internal sealed interface Intent {
    data class UpdateUsername(val username: String): Intent
    data class UpdatePassword(val password: String): Intent
    data class Login(val username: String, val password: String): Intent
}

internal data class State(
    val username: String = "",
    val password: String = ""
)


@OptIn(ExperimentalMviKotlinApi::class)
internal fun loginStore(storeFactory: StoreFactory) : Store<Intent, State, Nothing> =
    storeFactory.create<Intent, Nothing, Msg, State, Nothing>(
        name = "LoginStore",
        initialState = State(),
        executorFactory = coroutineExecutorFactory {
            onIntent<Intent.Login> { intent ->
                val token = logIn(intent.username, intent.password)
                dispatch(Msg.LoggedIn(token))
            }
            onIntent<Intent.UpdateUsername> { dispatch(Msg.UpdateUsername(it.username)) }
            onIntent<Intent.UpdatePassword> { dispatch(Msg.UpdatePassword(it.password)) }
        },
        reducer = { msg ->
            when (msg) {
                is Msg.LoggedIn -> copy()
                is Msg.UpdatePassword -> copy(password = msg.password)
                is Msg.UpdateUsername -> copy(username = msg.username)
            }
        }
    )

private sealed interface Msg {
    class UpdateUsername(val username: String): Msg
    class UpdatePassword(val password: String): Msg
    class LoggedIn(authToken: String) : Msg
}

private fun logIn(username: String, password:String) : String {
    // Authenticate the user
    // this is probably going to take a while
    // this will also return a auth token
    return "AuthToken"
}