plugins {
    id("microservices-kotlin-sandbox.kotlin-conventions")
}

dependencies {
    implementation(platform(project(":${project.rootProject.name}-dependencies")))

    implementation(libs.spring.boot.main)
    implementation(libs.bundles.kotlin)

    kapt(libs.spring.boot.configuration.processor)
}
