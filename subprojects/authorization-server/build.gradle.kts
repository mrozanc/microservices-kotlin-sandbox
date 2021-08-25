plugins {
    id("microservices-kotlin-sandbox.kotlin-conventions")
    application
}

dependencies {
    implementation(platform(project(":${project.rootProject.name}-dependencies")))

    runtimeOnly(libs.springdoc.openapi.ui)
    runtimeOnly(libs.springdoc.openapi.security)
    implementation(libs.spring.security.oauth2.authorization.server)
    implementation(libs.spring.boot.starter.security)
    implementation(libs.spring.boot.starter.web)
    implementation(libs.bundles.kotlin)
}

application {
    mainClass.set("fr.rozanc.sandbox.microservices.authorization.server.AuthorizationServerApplication")
}
