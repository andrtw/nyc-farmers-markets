plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.androidxCompose
    }
}

dependencies {
    implementation(project(":core-model"))
    implementation(project(":core-data"))
    testImplementation(project(":core-testing"))
    testImplementation(project(":core-data-testing"))
    androidTestImplementation(project(":core-testing"))

    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)

    implementation(Deps.androidxCoreKtx)
    implementation(Deps.androidxComposeUi)
    implementation(Deps.androidxComposeMaterial3)
    implementation(Deps.androidxComposeMaterialIconsExtended)
    implementation(Deps.androidxComposeUiToolingPreview)
    implementation(Deps.androidxLifecycleViewModelCompose)
    implementation(Deps.androidxNavigationCompose)
    implementation(Deps.androidxHiltNavigationCompose)
    implementation(Deps.androidxComposeMaterial3WindowSizeClass)
    implementation(Deps.accompanist)
}
