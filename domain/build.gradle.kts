plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {

    // Javax Inject
    api("javax.inject:javax.inject:1")

    // Kotlin
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
}