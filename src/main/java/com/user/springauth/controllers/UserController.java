package com.user.springauth.controllers;

import com.user.springauth.models.User;
import com.user.springauth.services.UserCORSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserCORSService userCorsService;

    @PreAuthorize("hasPermission({'ADMIN'}, 'saveAdmin')")
    @PostMapping("/saveAdmin")
    public String saveAdmin(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userCorsService.saveUser(user,"saveAdmin");

        return "Saved Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN'}, 'saveAdmin')")
    @PostMapping("/saveNormal")
    public String saveNormal(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userCorsService.saveUser(user,"saveNormal");
        return "Saved Successfully";
    }

    @PreAuthorize("hasPermission({'ADMIN'}, 'edit')")
    @PutMapping("/edit")
    public String edit(@RequestBody User user) {
        userCorsService.edit(user);
        return "Edited Successfully";
    }

    @GetMapping("/loadUserByUsername")
    public UserDetails loadUserByUsername() {
        var result = userCorsService.loadUserByUsername("admin7@miu.edu");
        return  result;
    }
    @PreAuthorize("hasPermission({'ADMIN'}, 'delete')")
    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        userCorsService.deleteById(id);
        return "Deleted Successfully";
    }
}
