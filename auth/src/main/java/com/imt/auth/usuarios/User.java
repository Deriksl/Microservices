package com.imt.auth.usuarios;


import com.imt.auth.repository.Token;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    public Long id;

    public String name;

    @Column(unique = true)
    public String email;
    public String password;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    public List<Token> tokens;
}
