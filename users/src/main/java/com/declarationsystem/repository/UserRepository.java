package com.declarationsystem.repository;

import com.declarationsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Métodos personalizados pueden agregarse aquí cuando sean necesarios
}