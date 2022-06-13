package com.user.springauth.controllers;

import com.user.springauth.JWT.JWTUtility;
import com.user.springauth.models.User;
import com.user.springauth.services.UserCORSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private UserCORSService userCorsService;

    private String token;

    @PostMapping("/login")
    public String authenticate(@RequestBody User jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("INVALID CREDENTIALS", ex);
        }
        final User user = userCorsService.getUserByUserName(jwtRequest.getUsername());
        final String token = jwtUtility.generateToken(user);
        this.token = token;
        return token;
    }


}
