package fr.rozanc.sandbox.microservices.gradle.keytool.tasks

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.OutputFile
import org.gradle.kotlin.dsl.property
import org.gradle.process.internal.ExecException
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset
import java.nio.charset.StandardCharsets

open class GenKeyPair : KeyToolTask() {

    @Input
    val keyName = project.objects.property<String>()
        .convention("${project.name}-key")

    @Input
    val keyPass = project.objects.property<String>()
        .convention("changeit")

    @Input
    val keystoreFilePath = project.objects.property<String>()
        .convention("${project.name}-keypair.jks")

    @OutputFile
    val keyStoreFile = project.objects.fileProperty()
        .convention { keystoreFilePath.map { fileName -> project.file(fileName) }.get() }

    override fun exec() {
        keyName.finalizeValue()
        keyPass.finalizeValue()
        keystoreFilePath.finalizeValue()
        keyStoreFile.finalizeValue()

        args(
            "-genkeypair",
            "-alias", keyName.get(),
            "-keyalg", "RSA",
            "-dname", "CN=Web Server,OU=Unit,O=Organization,L=Paris,S=Île-de-France,C=FR",
            "-keypass", keyPass.get(),
            "-keystore", keyStoreFile.get().asFile.absolutePath,
            "-storepass", keyPass.get()
        )

        val stdout = ByteArrayOutputStream()
        standardOutput = stdout

        try {
            super.exec()
        } catch (e: ExecException) {
            if (!stdout.toString(StandardCharsets.UTF_8).contains(Regex("keytool error: java.lang.Exception: Key pair not generated, alias <${keyName.get()}> already exists"))) {
                throw e
            } else {
                logger.warn("Ignoring existing \"${keyName.get()}\" key in ${keyStoreFile.get().asFile.absolutePath}")
            }
        }
    }
}
