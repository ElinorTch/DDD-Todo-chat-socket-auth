package com.example.chattrix.account.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.CreateUserUseCase;
import com.example.chattrix.account.domain.port.out.CreateUserRepository;
import com.example.chattrix.annotation.UseCase;

@UseCase
public class CreateUserService implements CreateUserUseCase {

    private final CreateUserRepository createUserRepository;

    public CreateUserService(CreateUserRepository createUserRepository) {
        this.createUserRepository = createUserRepository;
    }

    @Override
    public User createUser(User user) {
        return this.createUserRepository.save(user);
    }
}
