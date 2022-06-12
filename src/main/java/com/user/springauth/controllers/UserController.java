package com.user.springauth.controllers;

import com.user.springauth.models.User;
import com.user.springauth.services.UserPermissionService;
import com.user.springauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserPermissionService permissionService;

    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        userService.save(user);
        return "Saved Successfully";
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        permissionService.isAuthorized(id);
        return userService.getById(id);
    }

    @GetMapping("/getUserByName/{userName}")
    public User getUserByName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}
