buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath(kotlin(module = "gradle-plugin", version = "1.8.21"))
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.43.2")
        classpath(kotlin(module = "serialization", version = "1.8.21"))
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}