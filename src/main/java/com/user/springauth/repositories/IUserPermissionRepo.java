package com.user.springauth.repositories;

import com.user.springauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserPermissionRepo extends JpaRepository<User, Long> {
    @Query("SELECT distinct r.Type FROM User u LEFT join u.userRole r where u.Id =:id")
    List<String> getUserRoles(long id);
}
