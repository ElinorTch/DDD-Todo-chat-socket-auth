package com.example.chattrix.account.application.service;

import com.example.chattrix.account.domain.model.UserId;
import com.example.chattrix.account.domain.port.in.DeleteUserUseCase;
import com.example.chattrix.account.domain.port.out.DeleteUserRepository;
import com.example.chattrix.annotation.UseCase;

@UseCase
public class DeleteUserService implements DeleteUserUseCase {
    private final DeleteUserRepository deleteUserRepository;

    public DeleteUserService(DeleteUserRepository deleteUserRepository) {
        this.deleteUserRepository = deleteUserRepository;
    }

    @Override
    public void deleteUserById(UserId id) {
        this.deleteUserRepository.deleteById(id);
    }
}
