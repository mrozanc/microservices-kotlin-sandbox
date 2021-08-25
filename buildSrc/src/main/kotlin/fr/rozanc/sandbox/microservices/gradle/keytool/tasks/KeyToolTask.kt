package fr.rozanc.sandbox.microservices.gradle.keytool.tasks

import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.Exec
import org.gradle.jvm.toolchain.JavaToolchainService
import org.gradle.kotlin.dsl.getByType

abstract class KeyToolTask : Exec() {

    init {
        group = "keytool"
    }

    override fun exec() {
        val toolchain = project.extensions.getByType<JavaPluginExtension>().toolchain
        val javaToolchainService = project.extensions.getByType<JavaToolchainService>()
        val defaultLauncher = javaToolchainService.launcherFor(toolchain)
        val keytoolFile = defaultLauncher.get().executablePath.asFile.parentFile.listFiles { file ->
            file.name.matches(Regex("keytool(\\.exe)?"))
        }!!.first()

        executable = keytoolFile.absolutePath

        super.exec()
    }
}
