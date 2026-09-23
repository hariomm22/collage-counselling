package gov.counselling.collagecounselling.security;

import gov.counselling.collagecounselling.auth.CustomUserAccountDetailsService;
import gov.counselling.collagecounselling.exception.InvalidCredentialsException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilterConfig extends OncePerRequestFilter {

    private final JwtAuthService jwtService;
    private final CustomUserAccountDetailsService userAccountDetailsService;

    public JwtFilterConfig(
            JwtAuthService jwtService,
            CustomUserAccountDetailsService userAccountDetailsService
    ) {
        this.jwtService = jwtService;
        this.userAccountDetailsService = userAccountDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);

        try {

            Claims claims =
                    jwtService.extractAllClaims(token);

            String username =
                    claims.getSubject();

            if (username != null &&
                    SecurityContextHolder.getContext()
                            .getAuthentication() == null) {

                UserDetails userDetails =
                        userAccountDetailsService
                                .loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                userDetails,
                                null,
                                userDetails.getAuthorities()
                        );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }

        } catch (JwtException | IllegalArgumentException e) {

            System.out.println("JWT FILTER CATCH");
            throw new InvalidCredentialsException("Invalid Token/Credentials");


        }
        filterChain.doFilter(request, response);
    }
}