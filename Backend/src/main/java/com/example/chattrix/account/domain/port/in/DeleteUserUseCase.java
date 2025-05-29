package com.example.chattrix.account.domain.port.in;

import com.example.chattrix.account.domain.model.UserId;

public interface DeleteUserUseCase {
    void deleteUserById(UserId id);
}
