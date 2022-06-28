import Versions as v

object GradlePlugins {
    const val android = "com.android.tools.build:gradle:${v.androidGradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${v.kotlin}"
    const val kotlinSerialization = "org.jetbrains.kotlin:kotlin-serialization:${v.kotlin}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${v.hilt}"
}
