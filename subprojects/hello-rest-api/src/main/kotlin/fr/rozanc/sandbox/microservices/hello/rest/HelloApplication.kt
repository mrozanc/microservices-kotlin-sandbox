package fr.rozanc.sandbox.microservices.hello.rest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HelloApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<HelloApplication>(*args)
        }
    }
}
