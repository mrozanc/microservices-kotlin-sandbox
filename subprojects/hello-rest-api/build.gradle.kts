plugins {
    id("microservices-kotlin-sandbox.kotlin-conventions")
    application
}

dependencies {
    implementation(platform(project(":${project.rootProject.name}-dependencies")))

    implementation(project(":${project.rootProject.name}-configuration-api"))
    implementation(libs.springdoc.openapi.webflux.ui)
    implementation(libs.springdoc.openapi.security)
    implementation(libs.springdoc.openapi.kotlin)
    implementation(libs.spring.cloud.starter.config)
    implementation(libs.spring.cloud.starter.bootstrap)
    implementation(libs.spring.boot.starter.oauth2.resource.server)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.bundles.kotlin)
    runtimeOnly(libs.jackson.module.kotlin)
}

application {
    mainClass.set("fr.rozanc.sandbox.microservices.hello.rest.HelloApplication")
}

tasks {
    named<JavaExec>("run") {
        systemProperty("spring.cloud.config.profile", "marco,dev")
        systemProperty("spring.cloud.config.label", "master")
    }
}
