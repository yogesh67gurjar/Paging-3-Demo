plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    alias(libs.plugins.dagger.hilt)
}

android {
    namespace = "com.yogesh.paging3demo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yogesh.paging3demo"
        minSdk = 26
        targetSdk = 34
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
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.annotation)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)


    implementation(libs.androidx.paging.runtime)

    // dagger hilt
    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    // retrofit
    implementation(libs.retrofit)
    implementation(libs.gson.converter)

    // picasso for image processing
    implementation(libs.picasso)

    // viewmodel scope
    implementation(libs.viewModel.scope)

    // sdp ssp
    implementation(libs.sdp.android)
    implementation(libs.ssp.android)

    // circle imageview
    implementation(libs.circleimageview)

    // swipe refresh layout
    implementation (libs.androidx.swiperefreshlayout)

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}