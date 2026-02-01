plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.smartcompanion"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.smartcompanion"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    dependencies {
        // 1. Navigation for switching between Login, Dashboard, and Info screens
        implementation("androidx.navigation:navigation-compose:2.8.5")

        // 2. ViewModel for MVVM Architecture
        implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

        // 3. Material Icons (Extended) - Needed for the specific icons in the UI mockup
        implementation("androidx.compose.material:material-icons-extended:1.7.6")

        // 4. Lifecycle Utilities (for collecting states)
        implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    }
}