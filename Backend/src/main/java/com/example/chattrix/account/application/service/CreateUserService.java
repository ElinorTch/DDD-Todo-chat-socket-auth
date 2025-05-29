package com.example.chattrix.account.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.CreateUserUseCase;
import com.example.chattrix.account.domain.port.out.CreateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
