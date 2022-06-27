buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(BuildPlugins.android)
        classpath(BuildPlugins.kotlin)
        classpath(BuildPlugins.hilt)
    }
}

tasks.create<Delete>("clean") {
    delete {
        rootProject.buildDir
    }
}
