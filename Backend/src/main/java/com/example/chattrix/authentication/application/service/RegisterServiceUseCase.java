package com.example.chattrix.authentication.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.annotation.UseCase;
import com.example.chattrix.authentication.domain.port.in.RegisterUseCase;
import com.example.chattrix.authentication.domain.port.out.RegisterUserRepository;

@UseCase
public class RegisterServiceUseCase implements RegisterUseCase {
    private final RegisterUserRepository registerUserRepository;

    public RegisterServiceUseCase(RegisterUserRepository registerUserRepository) {
        this.registerUserRepository = registerUserRepository;
    }

    @Override
    public User register(String username, String password) {
        return this.registerUserRepository.register(username, password);
    }
}
