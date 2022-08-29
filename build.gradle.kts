buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.kotlin.serialization.gradlePlugin)
        classpath(libs.hilt.gradlePlugin)
        classpath(libs.secrets.gradlePlugin)
    }
}

tasks.create<Delete>("clean") {
    delete {
        rootProject.buildDir
    }
}
