package com.andrtw.nycfarmersmarkets.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(prj: Project) {
        with(prj) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }

            val libs = versionCatalog()

            dependencies {
                add("implementation", project(":core-model"))
                add("implementation", project(":core-data"))
                add("testImplementation", project(":core-testing"))
                add("testImplementation", project(":core-data-testing"))
                add("androidTestImplementation", project(":core-testing"))

                add("implementation", libs.findLibrary("hilt.android").get())
                add("kapt", libs.findLibrary("hilt.compiler").get())

                add("implementation", libs.findLibrary("androidx.core.ktx").get())
                add("implementation", libs.findLibrary("androidx.compose.ui").get())
                add("implementation", libs.findLibrary("androidx.compose.material3").get())
                add("implementation", libs.findLibrary("androidx.compose.material.iconsExtended").get())
                add("implementation", libs.findLibrary("androidx.compose.ui.toolingPreview").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.viewModel.compose").get())
                add("implementation", libs.findLibrary("androidx.lifecycle.runtime.compose").get())
                add("implementation", libs.findLibrary("androidx.navigation.compose").get())
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
            }
        }
    }
}
