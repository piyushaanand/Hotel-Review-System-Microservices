package com.userservice.userservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.userservice.models.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    
}
