package com.andrtw.nycfarmersmarkets.convention

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(prj: Project) {
        with(prj) {
            pluginManager.apply("com.android.application")
            extensions.configure<BaseAppModuleExtension> {
                configureAndroidCompose(libs = versionCatalog())
            }
        }
    }
}
