import fr.rozanc.sandbox.microservices.gradle.keytool.tasks.ExtractPublicCert
import fr.rozanc.sandbox.microservices.gradle.keytool.tasks.GenKeyPair
import org.gradle.kotlin.dsl.register

plugins {
    id("microservices-kotlin-sandbox.java-conventions")
}

tasks {
    val genKeyPair = register<GenKeyPair>("genKeyPair")
    register< ExtractPublicCert>("extractPublicCert") {
        dependsOn(genKeyPair)
    }
}
