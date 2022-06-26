package com.belzsoftware.voix.login

internal val stateToModel: (State) -> Login.Model = {
    Login.Model(username = it.username, password = it.password)
}