package com.declarationsystem.service;

import com.declarationsystem.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final List<User> users = new ArrayList<>();
    private Integer nextId = 1;

    // Obtener todos los usuarios
    public List<User> getAllUser() {
        return users;
    }

    // Obtener un usuario por ID
    public User getUserById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Agregar un nuevo usuario
    public User addUser(User user) {
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    // Actualizar un usuario existente
    public User updateUser(Integer id, User user) {
        Optional<User> existingUser = users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
        if (existingUser.isPresent()) {
            User updatedUser = existingUser.get();
            updatedUser.setName(user.getName());
            updatedUser.setEmail(user.getEmail());
            return updatedUser;
        }
        return null;
    }

    // Eliminar un usuario
    public boolean deleteUser(Integer id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}