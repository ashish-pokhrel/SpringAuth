package com.user.springauth.services;

import com.user.springauth.repositories.IUserPermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPermissionService {
    @Autowired
    private IUserPermissionRepo permissionRepo;

    public boolean isAuthorized(long id) {
        List<String> roles = permissionRepo.getUserRoles(id);
        return  true;
    }
}
