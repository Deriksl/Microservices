package com.imt.reservations.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin", "{bcrypt}$2a$10$TtR4frJ80pSPFZB0g2J6qu20P5soD9a/XDWvXaNhz9ZG3LfTmX9u.", Collections.emptyList()); // Contraseña: "password"
    }
}