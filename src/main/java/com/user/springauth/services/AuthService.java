package com.user.springauth.services;

import com.user.springauth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserCORSService userCorsService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userCorsService.loadUserByUsername(username);
//        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getPassword(), new ArrayList<>()
//        );
        return user;
    }

    public User getUserByUsername(String username) throws UsernameNotFoundException {
        User user = userCorsService.getUserByUserName(username);
//        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getPassword(), new ArrayList<>()
//        );
        return user;
    }
}
