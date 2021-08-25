plugins {
    id("microservices-kotlin-sandbox.kotlin-conventions")
    application
}

dependencies {
    implementation(platform(project(":${project.rootProject.name}-dependencies")))
    runtimeOnly(platform(project(":${project.rootProject.name}-dependencies")))

    runtimeOnly(libs.springdoc.openapi.ui)
//    runtimeOnly(libs.springdoc.openapi.security)
    implementation(libs.spring.cloud.config.server)
//    implementation(libs.spring.boot.starter.security)
    implementation(libs.bundles.kotlin)
}

application {
    mainClass.set("fr.rozanc.sandbox.microservices.configuration.server.ConfigurationServerApplication")
}

tasks {
    named<ProcessResources>("processResources") {
        val keystorePath = "$rootDir/server-hello.jks"
        inputs.file(keystorePath)
        from(keystorePath) to destinationDir
    }
}
