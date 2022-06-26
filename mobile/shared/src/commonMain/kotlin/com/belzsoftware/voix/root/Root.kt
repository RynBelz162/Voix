package com.belzsoftware.voix.root

import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.value.Value

interface Root {

    val routerState: Value<RouterState<*, Child>>

    sealed class Child {
        data class Login(val component: com.belzsoftware.voix.login.Login) : Child()
    }
}