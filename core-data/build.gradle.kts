plugins {
    id("nycfarmersmarkets.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.andrtw.nycfarmersmarkets.core.data"
}

dependencies {
    implementation(project(":core-network"))
    implementation(project(":core-model"))
    implementation(project(":core-database"))
    testImplementation(project(":core-testing"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    implementation(libs.kotlinx.coroutines.android)
}
