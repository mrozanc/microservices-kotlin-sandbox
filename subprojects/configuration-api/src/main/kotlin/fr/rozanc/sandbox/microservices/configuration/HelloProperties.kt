package fr.rozanc.sandbox.microservices.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import java.io.Serializable

@ConfigurationProperties("hello")
data class HelloProperties(
    var name: String = "world"
) : Serializable
