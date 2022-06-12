package com.user.springauth.services;

import com.user.springauth.models.User;
import com.user.springauth.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private IUserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.getUserByUserName(username);
        org.springframework.security.core.userdetails.User user1 = new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), new ArrayList<>()
        );
        return user1;
    }

    public void save(User user) {
//        if (!userRepo.existsById(user.getId()))
        userRepo.save(user);
    }

    public User getById(Long id) {
        var user = userRepo.findById(id);
        if (user == null)
            return new User();
        else
            return user.get();
    }

    public User getUserByUserName(String userName) {
        var user = userRepo.getUserByUserName(userName);
        return user;
    }

    public String getRoleById(Long id) {
        String role = userRepo.getRoleById(id);
        return role;
    }


}
