package fr.rozanc.sandbox.microservices.hello.rest.controller

import fr.rozanc.sandbox.microservices.configuration.HelloProperties
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController(private val helloProperties: HelloProperties) {

    @GetMapping("/hello")
    fun hello(): String {
        return "Hello ${helloProperties.name}!"
    }
}
