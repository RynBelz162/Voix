package com.belzsoftware.voix.login

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import com.arkivanov.decompose.value.operator.map
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.belzsoftware.voix.utils.asValue

class LoginComponent(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : Login, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        loginStore(storeFactory)
    }

    override val models: Value<Login.Model> = store.asValue().map(stateToModel)

    override fun onLogin() =
        store.accept(Intent.Login(models.value.username, models.value.password))

    override fun onPasswordChanged(password: String) =
        store.accept(Intent.UpdatePassword(password))

    override fun onUsernameChanged(username: String) =
        store.accept(Intent.UpdateUsername(username))
}