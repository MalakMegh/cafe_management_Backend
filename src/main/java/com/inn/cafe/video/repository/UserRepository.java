package com.inn.cafe.video.repository;

import com.inn.cafe.video.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> existsByEmail(@Param("email") String email);
    Optional<User> findByName(@Param("name") String name);
}
