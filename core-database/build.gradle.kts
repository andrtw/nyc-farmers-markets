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

        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf(
                    "room.schemaLocation" to "$projectDir/schemas",
                    "room.incremental" to "true",
                    "room.expandProjection" to "true"
                )
            }
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
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-opt-in=kotlin.RequiresOptIn",
        )
    }
}

dependencies {
    implementation(Deps.hiltAndroid)
    kapt(Deps.hiltCompiler)

    implementation(Deps.roomRuntime)
    implementation(Deps.roomKtx)
    kapt(Deps.roomCompiler)

    implementation(Deps.kotlinxCoroutinesAndroid)

    androidTestImplementation(Deps.googleTruth)
    androidTestImplementation(Deps.junit4)

    androidTestImplementation(Deps.kotlinxCoroutinesTest)
    androidTestImplementation(Deps.hiltAndroidTesting)
    androidTestImplementation(Deps.androidxTestCore)
    androidTestImplementation(Deps.androidxTestExt)
    androidTestImplementation(Deps.androidxTestEspressoCore)
    androidTestImplementation(Deps.androidxTestRunner)
    androidTestImplementation(Deps.androidxTestRules)
}
