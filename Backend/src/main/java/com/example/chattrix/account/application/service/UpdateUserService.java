package com.example.chattrix.account.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.UpdateUserUseCase;
import com.example.chattrix.account.domain.port.out.UpdateUserRepository;
import com.example.chattrix.annotation.UseCase;

@UseCase
public class UpdateUserService implements UpdateUserUseCase {
    private final UpdateUserRepository updateUserRepository;

    public UpdateUserService(UpdateUserRepository updateUserRepository) {
        this.updateUserRepository = updateUserRepository;
    }

    @Override
    public User updateUser(User user) {
        return this.updateUserRepository.update(user);
    }
}
