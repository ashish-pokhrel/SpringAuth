package com.user.springauth.controllers;

import com.user.springauth.models.Admin;
import com.user.springauth.models.Normal;
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

    @PostMapping("/saveAdmin")
    public String saveAdmin(@RequestBody Admin user) {
        userService.save(user);
        return "Saved Successfully";
    }

    @PostMapping("/saveNormal")
    public String saveNormal(@RequestBody Normal user) {
        userService.save(user);
        return "Saved Successfully";
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable Long id) {
        permissionService.isAuthorized(id);
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
