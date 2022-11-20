plugins {
    id("nycfarmersmarkets.android.library")
}

android {
    namespace = "com.andrtw.nycfarmersmarkets.core.data.testing"
}

dependencies {
    implementation(project(":core-testing"))
    implementation(project(":core-data"))
    implementation(project(":core-model"))
}
