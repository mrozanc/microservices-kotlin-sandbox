package fr.rozanc.sandbox.microservices.configuration.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigurationServerApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ConfigurationServerApplication>(*args)
        }
    }
}
