plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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
}

dependencies {
    implementation(project(":core-model"))

    api(Deps.junit4)
    api(Deps.googleTruth)
    api(Deps.kotlinxCoroutinesTest)
    api(Deps.robolectric)
    api(Deps.androidxTestCore)
    api(Deps.androidxTestExt)
    api(Deps.androidxTestEspressoCore)
    api(Deps.androidxTestRunner)
    api(Deps.androidxTestRules)
    api(Deps.androidxComposeUiTest)
    api(Deps.hiltAndroidTesting)
    debugApi(Deps.androidxComposeUiTestManifest)
}
