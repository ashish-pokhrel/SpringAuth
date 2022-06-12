package com.user.springauth.repositories;

import com.user.springauth.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRoleRepo extends JpaRepository<UserRole, Integer> {
}
