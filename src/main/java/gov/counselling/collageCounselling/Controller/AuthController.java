package gov.counselling.collagecounselling.controller;

import gov.counselling.collagecounselling.dto.CollageLoginRequest;
import gov.counselling.collagecounselling.service.JwtAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtAuthService jwtAuthService;

    @PostMapping("/login")
    public String authLogin(
            @RequestBody CollageLoginRequest request
    ){

        System.out.println("Inside authlogin");

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getCode(), request.getPassword()
        );
        System.out.println("is authenticated "+authentication.isAuthenticated());


        Authentication authenticated = authenticationManager.authenticate(authentication);

        System.out.println("is authenticated "+authenticated.isAuthenticated());

        return jwtAuthService.generateToken(authenticated);
    }

}

