// https://youtrack.jetbrains.com/issue/KTIJ-19369
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("com.android.application") version libs.versions.androidGradlePlugin.get() apply false
    id("com.android.library") version libs.versions.androidGradlePlugin.get() apply false
    kotlin("android") version libs.versions.kotlin.get() apply false
    kotlin("multiplatform") version libs.versions.kotlin.get() apply false
    id("com.google.dagger.hilt.android") version libs.versions.hilt.get() apply false
    kotlin("plugin.serialization") version libs.versions.kotlin.get() apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}