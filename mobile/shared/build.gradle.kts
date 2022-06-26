plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize") // Apply the plugin for Android
}

kotlin {
    android()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        all {
            languageSettings.optIn("kotlin.RequiresOptIn")
        }

        val commonMain by getting {
            dependencies {
                implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.0-beta02")
                implementation("com.arkivanov.mvikotlin:rx:3.0.0-beta02")
                implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.0-beta02")
                implementation("com.arkivanov.mvikotlin:mvikotlin-extensions-coroutines:3.0.0-beta02")
                implementation("com.arkivanov.decompose:decompose:0.6.0")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
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