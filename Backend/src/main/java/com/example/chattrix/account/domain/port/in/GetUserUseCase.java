package com.example.chattrix.account.domain.port.in;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;

import java.util.ArrayList;
import java.util.Optional;

public interface GetUserUseCase {
    Optional<User> getUserByEmailAndPassword(String username, String password);
}
