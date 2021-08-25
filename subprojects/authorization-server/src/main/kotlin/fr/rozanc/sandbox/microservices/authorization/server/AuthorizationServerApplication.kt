package fr.rozanc.sandbox.microservices.authorization.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AuthorizationServerApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<AuthorizationServerApplication>(*args)
        }
    }
}
