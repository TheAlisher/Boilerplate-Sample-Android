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

    // Kotlin Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    // Paging
    implementation("androidx.paging:paging-common:3.1.1")
}