plugins {
    id("nycfarmersmarkets.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    namespace = "com.andrtw.nycfarmersmarkets.core.network"
}

dependencies {
    testImplementation(project(":core-testing"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.okhttp)

    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
}
