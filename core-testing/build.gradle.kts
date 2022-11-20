plugins {
    id("nycfarmersmarkets.android.library")
}

android {
    namespace = "com.andrtw.nycfarmersmarkets.core.testing"
}

dependencies {
    implementation(project(":core-model"))

    api(libs.junit4)
    api(libs.google.truth)
    api(libs.kotlinx.coroutines.test)
    api(libs.robolectric)
    api(libs.androidx.test.core)
    api(libs.androidx.test.ext)
    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)
    debugApi(libs.androidx.compose.ui.testManifest)
}
