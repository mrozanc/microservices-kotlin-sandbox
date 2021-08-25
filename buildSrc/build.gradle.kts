plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
//    implementation(buildLibs.plugins.graalvm.native)
    implementation(buildLibs.plugins.dokka)
    implementation(buildLibs.plugins.kotlin.gradle)
    implementation(buildLibs.plugins.kotlin.allopen)
    implementation(buildLibs.plugins.kotlin.noarg)
    implementation(gradleApi())
    implementation(embeddedKotlin("stdlib-jdk8"))
}
