plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.keeper"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.keeper"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    // AndroidX https://developer.android.com/jetpack/androidx/versions/all-channel
    implementation(libs.activity.ktx)
    implementation(libs.activity.compose)
    implementation(libs.appcompat)
    implementation(libs.browser)
    implementation(libs.constraintlayout)
    implementation(libs.constraintlayout.compose)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.preference.ktx)
    implementation(libs.recyclerview)
    implementation(libs.work)

    // ViewModel
    implementation(libs.lifecycle.runtime.compose)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.lifecycle.viewmodel.ktx)

    // Navigation
    implementation(libs.navigation.compose)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)

    // Jetpack Compose UI
    implementation(platform(libs.compose.bom))
    implementation(libs.bundles.compose)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.activity)
    ksp(libs.room.compiler)

    // https://github.com/material-components/material-components-android/releases
    implementation(libs.material)
    implementation(libs.flexbox)

    // Accompanist https://github.com/google/accompanist
    implementation(libs.accompanist.themeadapter.material)
    implementation(libs.accompanist.systemuicontroller)
}