package com.user.springauth.controllers;

import com.user.springauth.models.UserRole;
import com.user.springauth.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/save")
    public String saveUser(@RequestBody UserRole userRole) {
        userRoleService.save(userRole);
        return "Saved Successfully";
    }

    @GetMapping("/get/{id}")
    public UserRole getUserRole(@PathVariable int id) {
        return userRoleService.getById(id);
    }
}
