package com.belzsoftware.voix.root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.RouterState
import com.arkivanov.decompose.router.router
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.belzsoftware.voix.login.Login
import com.belzsoftware.voix.login.LoginComponent

class RootComponent internal constructor(
    componentContext: ComponentContext,
    private val login: (ComponentContext) -> Login,
) : Root, ComponentContext by componentContext {

    constructor(
        componentContext: ComponentContext,
        storeFactory: StoreFactory,
    ) : this(
        componentContext = componentContext,
        login = { childContext ->
            LoginComponent(
                componentContext = childContext,
                storeFactory = storeFactory,
            )
        },
    )

    private val router =
        router<Configuration, Root.Child>(
            initialConfiguration = Configuration.Login,
            handleBackButton = true,
            childFactory = ::createChild
        )

    override val routerState: Value<RouterState<*, Root.Child>> = router.state

    private fun createChild(configuration: Configuration, componentContext: ComponentContext): Root.Child =
        when (configuration) {
            is Configuration.Login -> Root.Child.Login(login(componentContext))
        }

    private sealed class Configuration : Parcelable {

        @Parcelize
        object Login : Configuration()
    }
}