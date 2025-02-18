package com.carportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Allow all requests without authentication

//        For Security Measure
        //CSRF (Cross-Site Request Forgery): Prevents malicious requests from
        // unauthorized sources by adding a token to verify the legitimacy of the
        // request in Spring Security.
        //
        //CORS (Cross-Origin Resource Sharing): Allows or restricts
        // resources on the server to be requested from different origins (domains)
        // to ensure that only trusted sources can interact with the backend.

//        ➡️http.csrf(csrf -> csrf.disable()): Disables CSRF protection to allow non-authenticated requests.
//
//                http.cors(cors -> cors.disable()): Disables CORS to prevent cross-origin requests from different domains.
//
//        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll()): Allows all HTTP requests without any authentication or authorization.
// Don't use this type of syntax ⬇️ because it is depricated
        //http.csrf().disable().cors().disable();
        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable());
        // Shortcut to remember haap
        http.authorizeHttpRequests(auth -> auth.anyRequest().permitAll());

        return http.build();
    }

}

//✅ @Configuration → Marks the class as a Spring configuration class.
//✅ @Bean → Creates and registers a Spring-managed bean.
//✅ SecurityFilterChain → Defines security rules like authentication & authorization.
//We use @Configuration to define a class containing Spring bean definitions,
// and @Bean to register specific methods as Spring-managed beans for
// dependency injection.