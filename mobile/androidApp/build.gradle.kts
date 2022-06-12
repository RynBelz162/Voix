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
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.2.0-beta03"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.compose.ui:ui:1.2.0-beta03")
    implementation("androidx.compose.runtime:runtime:1.2.0-beta03")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.17.0")

    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling:1.2.0-beta03")

    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation("androidx.compose.foundation:foundation:1.2.0-beta03")

    // Material Design 3
    implementation("androidx.compose.material3:material3:1.0.0-alpha13")
    implementation("androidx.compose.material3:material3-window-size-class:1.0.0-alpha13")

    // Material design icons
    implementation("androidx.compose.material:material-icons-extended:1.2.0-beta03")

    // Integration with activities
    implementation("androidx.activity:activity-compose:1.4.0")
}