buildscript {
    val compose_version by extra("1.0.1")
    repositories {
        maven(url = "https://maven.google.com/")
        maven(url = "https://jitpack.io")
        mavenCentral()
        gradlePluginPortal()
        google()
    }
    val kotlinVersion: String by project

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-android-extensions:$kotlinVersion")
        classpath("com.android.tools.build:gradle:7.0.4")
    }
}

allprojects {
    repositories {
        maven(url = "https://maven.google.com")
        maven(url = "https://jitpack.io")
        maven(url = "https://repo1.maven.org/maven2")
        maven(url = "https://androidx.dev/snapshots/latest/artifacts/repository")
        maven(url = "https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        mavenCentral()
        google()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}