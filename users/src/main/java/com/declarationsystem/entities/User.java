package com.declarationsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Data
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;
    private String name;
    private String lastname;
    private String email;
    private String passwordHash; // Almacenar el hash de la contraseña

    public User(Integer id, String name, String email, char[] password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.passwordHash = hashPassword(password);
    }

    public User() {
    }

    // Método para hashear la contraseña
    private String hashPassword(char[] password) {
        try {
            // Convertir el char[] a String
            String passwordStr = new String(password);

            // Generar un salt aleatorio
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);

            // Crear el hash de la contraseña
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(passwordStr.getBytes());

            // Combinar el salt y el hash para almacenarlo
            byte[] combined = new byte[salt.length + hashedPassword.length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(hashedPassword, 0, combined, salt.length, hashedPassword.length);

            return Base64.getEncoder().encodeToString(combined);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al hashear la contraseña", e);
        }
    }

    // Método para verificar la contraseña
    public boolean verifyPassword(char[] password) {
        String newHash = hashPassword(password);
        return newHash.equals(this.passwordHash);
    }

    // Getters y setters (generados automáticamente por Lombok @Data)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


}