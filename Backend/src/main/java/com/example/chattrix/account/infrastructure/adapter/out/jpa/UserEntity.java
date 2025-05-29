package com.example.chattrix.account.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Entity
public class UserEntity {
    @Id
    private UUID id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    public UserEntity() {
    }

    public UserEntity(UUID id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public static UserEntity fromDomain(User user) {
        return new UserEntity(user.getId().id(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    public User toDomain() {
        return new User(this.username, this.email, this.password);
    }

}
