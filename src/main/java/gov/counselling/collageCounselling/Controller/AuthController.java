package gov.counselling.collagecounselling.controller;

import gov.counselling.collagecounselling.dto.CurrentUserAccountReponse;
import gov.counselling.collagecounselling.dto.UserAccountLoginRequest;
import gov.counselling.collagecounselling.security.JwtAuthService;
import gov.counselling.collagecounselling.service.UserAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("auth")
public class AuthController {


    final private AuthenticationManager authenticationManager;

    final private JwtAuthService jwtAuthService;

    final private UserAccountService userAccountService;


    public AuthController(AuthenticationManager authenticationManager,
                          JwtAuthService jwtAuthService,
                          UserAccountService userAccountService){
        this.authenticationManager=authenticationManager;
        this.jwtAuthService=jwtAuthService;
        this.userAccountService=userAccountService;
    }

    @PostMapping("/login")
    public String authLogin(
            @RequestBody UserAccountLoginRequest request
    ) {

        Authentication authentication = new UsernamePasswordAuthenticationToken(
                request.getUserName(), request.getPassword()
        );
        log.info("is autheticated {} ",authentication.isAuthenticated());

        Authentication authenticated = authenticationManager.authenticate(authentication);

        log.info("authenticated user authoritires {} ",authenticated.getAuthorities().toString());

        return jwtAuthService.generateToken(authenticated);
    }

    @GetMapping("/profile")
    public CurrentUserAccountReponse getCurrentProfile(Authentication authentication){
        return userAccountService.getCurrentAccountReponse(authentication);
    }

}

