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
}

dependencies {
    implementation(project(":core-model"))

    api(Deps.junit4)
    api(Deps.googleTruth)
    api(Deps.kotlinxCoroutinesTest)
    api(Deps.androidxTestCore)
    api(Deps.androidxTestExt)
    api(Deps.androidxTestEspressoCore)
    api(Deps.androidxTestRunner)
    api(Deps.androidxTestRules)
    api(Deps.androidxComposeUiTest)
    api(Deps.hiltAndroidTesting)
    debugApi(Deps.androidxComposeUiTestManifest)
}
