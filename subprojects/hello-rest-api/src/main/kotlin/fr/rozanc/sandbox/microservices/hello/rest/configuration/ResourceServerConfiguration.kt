package fr.rozanc.sandbox.microservices.hello.rest.configuration

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
class ResourceServerConfiguration {

    @Bean
    fun securityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.authorizeExchange { exchanges ->
            exchanges.pathMatchers("/hello/**").hasAuthority("SCOPE_hello.read")
                .pathMatchers("/swagger-ui.html").permitAll()
                .pathMatchers("/v3/api-docs/**").permitAll()
                .pathMatchers("/webjars/swagger-ui/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt()
        }
        return http.build()
    }
}
