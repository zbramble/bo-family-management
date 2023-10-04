package com.example.backend.controller;

import com.example.backend.model.Greeting;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    @GetMapping("/hello")
    public Mono<Greeting> handle() {
        return Mono.just(new Greeting("Hello, I'm Backend V2!"));
    }

    @GetMapping("/oidc-principal")
    public Mono<OidcUser> getOidcUserPrincipal(
            @AuthenticationPrincipal OidcUser principal) {

        return Mono.just(principal);
    }
}