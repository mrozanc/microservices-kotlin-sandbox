plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    api(platform(libs.kotlin.bom))
    api(platform(libs.spring.cloud.dependencies))
    api(platform(libs.spring.boot.dependencies))
}
