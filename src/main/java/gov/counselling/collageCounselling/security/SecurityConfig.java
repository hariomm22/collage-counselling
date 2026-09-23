package gov.counselling.collagecounselling.security;

import gov.counselling.collagecounselling.auth.CustomUserAccountDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private  final JwtFilterConfig jwtFilterConfig;



    public SecurityConfig(JwtFilterConfig jwtFilterConfig){

        this.jwtFilterConfig = jwtFilterConfig;

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity ,
                                                   AuthenticationProvider provider,
                                                   CustomAuthenticationEntryPoint authenticationEntryPoint,
                                                   CustomAccessDeniedHandler accessDeniedHandler
                                                   ){
        HttpSecurity httpSecurity1 = httpSecurity
                .csrf(csrf -> csrf.disable())

                .exceptionHandling( exception -> exception
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler)
                )

                .sessionManagement(session ->
                        session.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )
                //if we difine authentcation provider then we should add provider in filter chain
                .authenticationProvider(provider)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/health-check/**","/collage/register","/student/register",
                                "/auth/login").permitAll()
                        .requestMatchers("/collage/**").hasAnyRole("COLLAGE","ADMIN")
                        .requestMatchers("/student/**").hasRole("STUDENT")
                        .anyRequest().authenticated())
                .addFilterBefore(
                        jwtFilterConfig,
                        UsernamePasswordAuthenticationFilter.class
                );

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }


    // This Authentication Provider bean is totally optional if we not define spring security automatically add it in filer change
    @Bean
    public DaoAuthenticationProvider authenticationProvider(
            CustomUserAccountDetailsService customUserAccountDetailsService,
            PasswordEncoder passwordEncoder){

        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider(customUserAccountDetailsService);
        provider.setPasswordEncoder(passwordEncoder);

        return  provider;
    }


    @Bean
    public AuthenticationManager authenticationManager
            (DaoAuthenticationProvider provider){
        return new ProviderManager(provider);
    }

}
