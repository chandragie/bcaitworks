package com.bca.itworks.repository;

import java.util.Optional;
import java.util.UUID;

import com.bca.itworks.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findById(UUID id);

    Optional<User> findByUsernameAndPassword(String username, String password);
}
