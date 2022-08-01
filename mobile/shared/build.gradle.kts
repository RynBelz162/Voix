plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize") // Apply the plugin for Android
}

kotlin {
    android()
    ios()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "Shared"
            export("com.arkivanov.decompose:decompose:0.6.0")
            export("com.arkivanov.essenty:lifecycle:0.4.2")
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }

        commonMain {
            dependencies {
                implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.0-beta02")
                implementation("com.arkivanov.mvikotlin:rx:3.0.0-beta02")
                implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.0-beta02")
                implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:3.0.0-beta02")
                implementation("com.arkivanov.decompose:decompose:0.6.0")
                implementation("com.arkivanov.essenty:lifecycle:0.4.2")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
            }
        }

        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        named("iosMain") {
            dependencies {
                api("com.arkivanov.mvikotlin:mvikotlin:3.0.0-beta02")
                api("com.arkivanov.mvikotlin:rx:3.0.0-beta02")
                api("com.arkivanov.mvikotlin:mvikotlin-main:3.0.0-beta02")
                api("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:3.0.0-beta02")
                api("com.arkivanov.decompose:decompose:0.6.0")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
                api("com.arkivanov.essenty:lifecycle:0.4.2")
            }
        }
    }
}

android {
    compileSdk = 32
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 26
        targetSdk = 32
    }
}