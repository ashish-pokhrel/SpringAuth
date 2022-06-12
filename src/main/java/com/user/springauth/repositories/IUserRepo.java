package com.user.springauth.repositories;

import com.user.springauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {
    @Query("select  u from User u Where u.UserName =:userName")
    User getUserByUserName(String userName);

    @Query("select u.Role from User u Where u.Id =:id")
    String getRoleById(long id);
}
