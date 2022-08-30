plugins {
    id("nycfarmersmarkets.android.library")
    id("nycfarmersmarkets.android.library.compose")
    id("nycfarmersmarkets.android.feature")
    id("dagger.hilt.android.plugin")
}

dependencies {
    implementation(libs.maps.compose)
    implementation(libs.gms.playServices.maps)
}
