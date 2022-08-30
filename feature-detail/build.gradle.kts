plugins {
    id("nycfarmersmarkets.android.library")
    id("nycfarmersmarkets.android.library.compose")
    id("nycfarmersmarkets.android.feature")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.accompanist.flowlayout)
}
