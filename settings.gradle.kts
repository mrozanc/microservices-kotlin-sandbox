enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        val kotlinVersion: String by settings
        kotlin("jvm") version kotlinVersion
    }
}

rootProject.name = "microservices-kotlin-sandbox"

file("$rootDir/subprojects")
    .listFiles { file -> file.isDirectory }
    ?.forEach { subProjectDir ->
        val subProjectName = ":${rootProject.name}-${subProjectDir.name}"
        include(subProjectName)
        project(subProjectName).projectDir = subProjectDir
}
