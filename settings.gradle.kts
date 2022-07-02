pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "nyc-farmers-markets"

include(":app")
include(":core-model")
include(":core-network")
include(":core-data")
include(":core-database")
include(":feature-map")
include(":feature-detail")
