package com.user.springauth.services;

import com.user.springauth.models.UserRole;
import com.user.springauth.repositories.IUserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private IUserRoleRepo userRoleRepo;

    public void save(UserRole userRole) {
        //if(!userRoleRepo.existsById(userRole.getId()))
            userRoleRepo.save(userRole);
    }

    public UserRole getById(int id) {
        var userRole = userRoleRepo.findById(id);
        if (userRole == null)
            return new UserRole();
        else
            return userRole.get();
    }
}
