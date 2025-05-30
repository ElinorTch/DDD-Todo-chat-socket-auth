package com.example.chattrix.authentication.domain.port.out;

import com.example.chattrix.account.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginUserRepository {
    Optional<User> login(String email, String password);
}
