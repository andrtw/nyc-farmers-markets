plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

secrets {
    propertiesFileName = "secrets.properties"
}

android {
    compileSdk = Config.compileSdk

    defaultConfig {
        applicationId = "com.andrtw.nycfarmersmarkets"
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(Deps.androidxCoreKtx)
    implementation(Deps.androidxComposeUi)
    implementation(Deps.androidxComposeMaterial3)
    implementation(Deps.androidxComposeUiToolingPreview)
    implementation(Deps.androidxActivityCompose)

    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)

    testImplementation(Deps.junit4)
    androidTestImplementation(Deps.androidxTestExt)
    androidTestImplementation(Deps.androidxTestEspressoCore)
    androidTestImplementation(Deps.androidxComposeUiTest)
    debugImplementation(Deps.androidxComposeUiTooling)
    debugImplementation(Deps.androidxComposeUiTestManifest)
}
