package com.irojas.oauth.resourceserver.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @GetMapping("/user")
    public ResponseEntity<String> read_user (Authentication authentication)
    {
        return ResponseEntity.ok("The user can read." + authentication.getName() +  authentication.getAuthorities() );
    }

    @PostMapping("/user")
    public ResponseEntity<String> write_user (Authentication authentication)
    {
        return ResponseEntity.ok("The user can write." +authentication.getAuthorities() );
    }
}
