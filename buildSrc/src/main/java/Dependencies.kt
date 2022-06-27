import Versions as v

object BuildPlugins {
    const val android = "com.android.tools.build:gradle:${v.androidGradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${v.kotlin}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${v.hilt}"
}

object Deps {
    const val androidxCoreKtx = "androidx.core:core-ktx:${v.androidxCore}"
    const val androidxActivityCompose = "androidx.activity:activity-compose:${v.androidxActivity}"
    const val androidxComposeUi = "androidx.compose.ui:ui:${v.androidxCompose}"
    const val androidxComposeMaterial3 = "androidx.compose.material3:material3:${v.androidxComposeMaterial3}"
    const val androidxComposeUiTooling = "androidx.compose.ui:ui-tooling:${v.androidxCompose}"
    const val androidxComposeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${v.androidxCompose}"
    const val androidxComposeUiTest = "androidx.compose.ui:ui-test-junit4:${v.androidxCompose}"
    const val androidxComposeUiTestManifest = "androidx.compose.ui:ui-test-manifest:${v.androidxCompose}"
    const val androidxTestExtJunit = "androidx.test.ext:junit:${v.androidxTestExt}"
    const val androidxTestEspressoCore = "androidx.test.espresso:espresso-core:${v.androidxEspresso}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${v.hilt}"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${v.hilt}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${v.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${v.retrofit}"
    const val retrofitKotlinxSerializationConverter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${v.retrofitKotlinxSerializationConverter}"

    const val kotlinxSerializationJson = "org.jetbrains.kotlinx:kotlinx-serialization-json:${v.kotlinxSerializationJson}"

    const val junit4 = "junit:junit:${v.junit4}"
    const val googleTruth = "com.google.truth:truth:${v.googleTruth}"
}
