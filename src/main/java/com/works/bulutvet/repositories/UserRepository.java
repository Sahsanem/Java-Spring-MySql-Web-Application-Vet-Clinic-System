package com.works.bulutvet.repositories;

import com.works.bulutvet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmailEqualsAllIgnoreCase(String email);

}
