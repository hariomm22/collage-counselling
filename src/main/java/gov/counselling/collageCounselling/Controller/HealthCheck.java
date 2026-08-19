package gov.counselling.collagecounselling.controller;

import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health-check")
public class HealthCheck {

    @GetMapping
    public String getHealth() {
        return "ok..";
    }

    @GetMapping("/cp")
    public CsrfToken getCsrfToken(CsrfToken token) {
         return token;
    }

}
