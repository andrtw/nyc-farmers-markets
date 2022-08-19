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
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.RequiresOptIn",
            // Enable experimental coroutines APIs, including Flow
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.coroutines.FlowPreview",
            "-opt-in=kotlin.Experimental",
            // Enable experimental kotlinx serialization APIs
            "-opt-in=kotlinx.serialization.ExperimentalSerializationApi"
        )
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
    implementation(Deps.androidxComposeUiToolingPreview)
    implementation(Deps.androidxLifecycleViewModelCompose)
    implementation(Deps.androidxLifecycleRuntimeCompose)
    implementation(Deps.androidxNavigationCompose)
    implementation(Deps.androidxHiltNavigationCompose)

    implementation(Deps.mapsCompose)
    implementation(Deps.gmsPlayServicesMaps)
}
