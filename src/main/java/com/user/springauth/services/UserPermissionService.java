package com.user.springauth.services;

import com.user.springauth.models.User;
import com.user.springauth.repositories.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPermissionService {
    @Autowired
    private IUserRepo userRepo;

    public boolean isAuthorized(long id) {
        User user = userRepo.getById(id);
        return true;
    }
}
