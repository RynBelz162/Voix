package com.belzsoftware.voix.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetpack.Children
import com.arkivanov.mvikotlin.main.store.DefaultStoreFactory
import com.belzsoftware.voix.android.login.LoginScreen
import com.belzsoftware.voix.android.styling.AppTheme
import com.belzsoftware.voix.root.Root
import com.belzsoftware.voix.root.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = createRootComponent(defaultComponentContext())

        setContent {
            AppTheme {
                RootContent(root)
            }
        }
    }

    private fun createRootComponent(componentContext: ComponentContext): Root =
        RootComponent(
            componentContext = componentContext,
            storeFactory = DefaultStoreFactory(),
        )

    @OptIn(com.arkivanov.decompose.ExperimentalDecomposeApi::class)
    @Composable
    fun RootContent(component: Root) {
        Children(routerState = component.routerState) {
            when (val child = it.instance) {
                is Root.Child.Login -> LoginScreen(child.component)
            }
        }
    }
}
