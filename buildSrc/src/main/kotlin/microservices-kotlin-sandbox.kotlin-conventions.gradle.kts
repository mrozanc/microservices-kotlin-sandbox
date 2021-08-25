import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("microservices-kotlin-sandbox.java-conventions")
    kotlin("jvm")
    kotlin("plugin.jpa")
    kotlin("plugin.spring")
    kotlin("kapt")
    id("org.jetbrains.dokka")
}

configurations {
    configureEach {
        if (name == "compileClasspath" || name.endsWith("CompileClasspath")
            || name == "runtimeClasspath" || name.endsWith("RuntimeClasspath")
            || name == "annotationProcessor" || name.endsWith("AnnotationProcessor")) {
            resolutionStrategy.failOnNonReproducibleResolution()
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.register<Jar>("javadocJar") {
    val dokkaJavadoc = tasks.named<DokkaTask>("dokkaJavadoc")
    dependsOn(dokkaJavadoc)
    archiveClassifier.set("javadoc")
    from(dokkaJavadoc.map { it.outputDirectory })
}

configure<JavaPluginExtension> {
    withJavadocJar()
    withSourcesJar()
}
