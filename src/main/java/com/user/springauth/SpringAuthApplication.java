package com.user.springauth;

import com.user.springauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAuthApplication {

    @Autowired
    private UserService userService;

   // @PostConstruct
    public void saveInitialUser() {
//        List<UserRole> userRoles = new ArrayList<>();
//        List<UserRole> userRoles2 = new ArrayList<>();
//        UserRole userRole = new UserRole(1, "Admin");
//        UserRole userRole2 = new UserRole(2, "Normal");
//        roleService.save(userRole);
//        roleService.save(userRole2);
//
//        userRoles.add(userRole);
//        userRoles2.add(userRole2);
//        User user = new User(3L, "admin@miu.edu", "12345678", true, userRoles);
//        User user2 = new User(4L, "normal@miu.edu", "12345678", true, userRoles2);
//        userService.save(user);
//        userService.save(user2);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringAuthApplication.class, args);
    }

}
