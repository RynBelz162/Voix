plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 32
    buildFeatures {
        compose = true
    }
    defaultConfig {
        applicationId = "com.belzsoftware.voix.android"
        minSdk = 26
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs += "-opt-in=kotlin.RequiresOptIn"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta03"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.compose.ui:ui:1.3.0-alpha02")
    implementation("androidx.compose.runtime:runtime:1.3.0-alpha02")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")

    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.3.0-alpha02")

    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.3.0-alpha02")

    // Material Design 3
    implementation("androidx.compose.material3:material3:1.0.0-alpha15")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-alpha15")

    // Material design icons
    implementation("androidx.compose.material:material-icons-extended:1.3.0-alpha02")

    // Integration with activities
    implementation("androidx.activity:activity-compose:1.5.1")

    // MVI Kotlin
    implementation("com.arkivanov.mvikotlin:mvikotlin:3.0.0-beta02")
    implementation("com.arkivanov.mvikotlin:mvikotlin-main:3.0.0-beta02")

    // Decompose extensions
    implementation("com.arkivanov.decompose:decompose:0.6.0")
    implementation("com.arkivanov.decompose:extensions-android:0.6.0")
    implementation("com.arkivanov.decompose:extensions-compose-jetpack:0.6.0")
}