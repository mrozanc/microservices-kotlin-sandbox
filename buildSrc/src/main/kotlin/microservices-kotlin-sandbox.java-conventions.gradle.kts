plugins {
    java
//    id("org.graalvm.buildtools.native")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
//        vendor.set(JvmVendorSpec.GRAAL_VM)
    }
}

//nativeBuild {
//    buildArgs(
//        "--enable-all-security-services",
//        "--initialize-at-build-time=org.springframework.util.unit.DataSize",
//        "--allow-incomplete-classpath"
//    )
//}
