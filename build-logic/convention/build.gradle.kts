plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "nycfarmersmarkets.android.application"
            implementationClass = "com.andrtw.nycfarmersmarkets.convention.AndroidApplicationConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "nycfarmersmarkets.android.application.compose"
            implementationClass = "com.andrtw.nycfarmersmarkets.convention.AndroidApplicationComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "nycfarmersmarkets.android.library"
            implementationClass = "com.andrtw.nycfarmersmarkets.convention.AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "nycfarmersmarkets.android.library.compose"
            implementationClass = "com.andrtw.nycfarmersmarkets.convention.AndroidLibraryComposeConventionPlugin"
        }
        register("androidFeature") {
            id = "nycfarmersmarkets.android.feature"
            implementationClass = "com.andrtw.nycfarmersmarkets.convention.AndroidFeatureConventionPlugin"
        }
    }
}
