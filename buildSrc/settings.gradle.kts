enableFeaturePreview("VERSION_CATALOGS")

dependencyResolutionManagement {
    versionCatalogs {
        create("buildLibs") {
            from(files("../gradle/build-libs.versions.toml"))
        }
    }
}
