plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.thanasis.kottaridis.thannewskmm.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.thanasis.kottaridis.thannewskmm.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
}

dependencies {
    // shared kmm module import
    implementation(projects.shared)

    // base android imports
    implementation("androidx.appcompat:appcompat:1.6.1")

    implementation("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.0")
    implementation("androidx.navigation:navigation-runtime-ktx:2.7.0")

    // jetpack compose imports
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)

    // coil for async loading images from web
    implementation(libs.coil.compose)

    // Koin for DI
    implementation(libs.koin.android)
    implementation(libs.koin.android.compose)

    // debug tools
    debugImplementation(libs.compose.ui.tooling)
}
