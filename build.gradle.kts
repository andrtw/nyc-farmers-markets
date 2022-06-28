buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(GradlePlugins.android)
        classpath(GradlePlugins.kotlin)
        classpath(GradlePlugins.kotlinSerialization)
        classpath(GradlePlugins.hilt)
    }
}

tasks.create<Delete>("clean") {
    delete {
        rootProject.buildDir
    }
}
