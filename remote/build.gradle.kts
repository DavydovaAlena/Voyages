plugins {
    alias(libs.plugins.serialization)
    alias(libs.plugins.jetbrainsKotlinJvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    implementation(libs.coroutines.core)
    implementation(libs.coroutines.android)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.client.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.serialization.kotlinx.json)
    implementation (libs.androidx.paging.compose)
    implementation (libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.common.ktx)

}