package com.example.chattrix.authentication.domain.port.in;

import com.example.chattrix.account.domain.model.User;

import java.util.Optional;

public interface LoginUseCase {
    Optional<User> loginUser(String username, String password);
}
