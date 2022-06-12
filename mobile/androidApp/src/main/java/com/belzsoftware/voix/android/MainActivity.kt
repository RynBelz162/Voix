package com.belzsoftware.voix.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.belzsoftware.voix.android.login.LoginScreen
import com.belzsoftware.voix.android.styling.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                LoginScreen()
            }
        }
    }
}
