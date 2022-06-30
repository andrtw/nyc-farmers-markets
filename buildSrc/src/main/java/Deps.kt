import Versions as v

object Deps {
    const val androidxCoreKtx = "androidx.core:core-ktx:${v.androidxCore}"
    const val androidxActivityCompose = "androidx.activity:activity-compose:${v.androidxActivity}"
    const val androidxComposeUi = "androidx.compose.ui:ui:${v.androidxCompose}"
    const val androidxComposeMaterial3 = "androidx.compose.material3:material3:${v.androidxComposeMaterial3}"
    const val androidxComposeUiTooling = "androidx.compose.ui:ui-tooling:${v.androidxCompose}"
    const val androidxComposeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${v.androidxCompose}"
    const val androidxComposeUiTest = "androidx.compose.ui:ui-test-junit4:${v.androidxCompose}"
    const val androidxComposeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${v.androidxCompose}"
    const val androidxTestCore = "androidx.test:core:${v.androidxTest}"
    const val androidxTestExt = "androidx.test.ext:junit-ktx:${v.androidxTestExt}"
    const val androidxTestEspressoCore = "androidx.test.espresso:espresso-core:${v.androidxEspresso}"
    const val androidxTestRunner = "androidx.test:runner:${v.androidxTest}"
    const val androidxTestRules = "androidx.test:rules:${v.androidxTest}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${v.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${v.hilt}"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${v.hilt}"

    const val roomRuntime = "androidx.room:room-runtime:${v.room}"
    const val roomCompiler = "androidx.room:room-compiler:${v.room}"
    const val roomKtx = "androidx.room:room-ktx:${v.room}"
    const val roomTesting = "androidx.room:room-testing:${v.room}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${v.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${v.retrofit}"
    const val retrofitKotlinxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${v.retrofitKotlinxSerializationConverter}"

    const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${v.kotlinxSerializationJson}"
    const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${v.kotlinxCoroutines}"
    const val kotlinxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${v.kotlinxCoroutines}"

    const val mapsCompose = "com.google.maps.android:maps-compose:${v.mapsCompose}"
    const val gmsPlayServicesMaps = "com.google.android.gms:play-services-maps:${v.gmsPlayServicesMaps}"

    const val junit4 = "junit:junit:${v.junit4}"
    const val googleTruth = "com.google.truth:truth:${v.googleTruth}"
}
