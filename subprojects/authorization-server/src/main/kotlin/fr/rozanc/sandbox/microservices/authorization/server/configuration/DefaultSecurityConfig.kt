package fr.rozanc.sandbox.microservices.authorization.server.configuration

import org.springframework.context.annotation.Bean
import org.springframework.security.config.Customizer.withDefaults
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@EnableWebSecurity
class DefaultSecurityConfig {

    @Bean
    fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeRequests { authorizeRequests ->
            authorizeRequests.anyRequest().authenticated()
        }.formLogin(withDefaults())
        return http.build()
    }

    @Bean
    fun users(): UserDetailsService? {
        val user: UserDetails = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("password")
            .roles("ADMIN")
            .build()
        return InMemoryUserDetailsManager(user)
    }
}
