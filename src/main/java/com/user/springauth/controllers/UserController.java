package com.user.springauth.controllers;

import com.user.springauth.JWT.JWTUtility;
import com.user.springauth.models.Admin;
import com.user.springauth.models.Normal;
import com.user.springauth.models.User;
import com.user.springauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtility jwtUtility;

    @PostMapping("/login")
    public String authenticate(@RequestBody User jwtRequest) throws Exception {
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUserName());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("INVALID CREDENTIALS", ex);
        }
        final String token = jwtUtility.generateToken(userDetails);
        return token;
    }

    @PostMapping("/saveAdmin")
    public String saveAdmin(@RequestBody Admin user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "Saved Successfully";
    }

    @PostMapping("/saveNormal")
    public String saveNormal(@RequestBody Normal user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "Saved Successfully";
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping("/getRoleById/{id}")
    public String getRoleById(@PathVariable Long id) {
        return userService.getRoleById(id);
    }

    @GetMapping("/getUserByName/{userName}")
    public User getUserByName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}
