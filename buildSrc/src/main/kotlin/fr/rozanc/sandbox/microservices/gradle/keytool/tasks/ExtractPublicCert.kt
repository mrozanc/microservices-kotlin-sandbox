package fr.rozanc.sandbox.microservices.gradle.keytool.tasks

import org.gradle.api.file.RegularFile
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.OutputFile
import org.gradle.kotlin.dsl.named
import org.gradle.kotlin.dsl.property

open class ExtractPublicCert : KeyToolTask() {

    @Input
    val keyName = project.objects.property<String>()
        .convention(project.tasks.named<GenKeyPair>("genKeyPair").map { it.keyName.get() })

    @Input
    val keyPass = project.objects.property<String>()
        .convention(project.tasks.named<GenKeyPair>("genKeyPair").map { it.keyPass.get() })

    @InputFile
    val keystoreFile = project.objects.fileProperty()
        .convention(project.tasks.named<GenKeyPair>("genKeyPair").map { it.keyStoreFile.get() })

    @Input
    val certStoreFilePath = project.objects.property<String>()
        .convention("${project.name}-cert.jks")

    @OutputFile
    val certStoreFile = project.objects.fileProperty()
        .convention { certStoreFilePath.map { fileName -> project.file(fileName) }.get() }

    override fun exec() {
        keyName.finalizeValue()
        keyPass.finalizeValue()
        keystoreFile.finalizeValue()
        certStoreFilePath.finalizeValue()
        certStoreFile.finalizeValue()

        args(
            "-exportcert",
            "-keystore", keystoreFile.asFile.get().absolutePath,
            "-storepass", keyPass.get(),
            "-alias", keyName.get(),
            "-file", "${keyName.get()}.cer",
            "-rfc"
        )

        super.exec()

        setArgs(listOf(
            "-importcert",
            "-noprompt",
            "-file", "${keyName.get()}.cer",
            "-alias", keyName.get(),
            "-keystore", certStoreFile.asFile.get().absolutePath,
            "-storepass", keyPass.get()
        ))

        super.exec()
    }
}
