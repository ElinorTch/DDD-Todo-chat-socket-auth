package com.example.chattrix.account.domain.port.out;

import com.example.chattrix.account.domain.model.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    Optional<User> findById(UUID id);
    void save(User user);
    void deleteById(UUID id);
}
