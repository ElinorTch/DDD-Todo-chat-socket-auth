package com.example.chattrix.account.domain.port.in;

import com.example.chattrix.account.domain.model.User;

public interface UpdateUserUseCase {
    User updateUser(User user);
}
