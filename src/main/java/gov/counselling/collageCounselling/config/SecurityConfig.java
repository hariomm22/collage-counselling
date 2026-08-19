package gov.counselling.collagecounselling.config;

import gov.counselling.collagecounselling.auth.CustomCollageDetailsService;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity , AuthenticationProvider provider){
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity){
        HttpSecurity httpSecurity1 = httpSecurity
                .csrf(csrf -> csrf.disable())
                //if we difine authentcation provider then we should add provider in filter chain
//                .authenticationProvider(provider)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/health-check/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // This Authentication Provider bean is totally optional if we not define spring security automatically add it in filer change
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(CustomCollageDetailsService customCollageDetailsService, PasswordEncoder passwordEncoder){
//
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(customCollageDetailsService);
//        provider.setPasswordEncoder(passwordEncoder);
//
//        return  provider;
//    }

}
