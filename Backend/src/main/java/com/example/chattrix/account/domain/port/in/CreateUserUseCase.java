package com.example.chattrix.account.domain.port.in;

import com.example.chattrix.account.domain.model.User;

public interface CreateUserUseCase {
    User createUser(User user);
}
