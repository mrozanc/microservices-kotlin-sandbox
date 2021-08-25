package fr.rozanc.sandbox.microservices.hello.rest.configuration

import fr.rozanc.sandbox.microservices.configuration.HelloProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(HelloProperties::class)
class HelloRestConfiguration
