package com.example.chattrix.authentication.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.annotation.UseCase;
import com.example.chattrix.authentication.domain.port.in.LoginUseCase;
import com.example.chattrix.authentication.domain.port.out.LoginUserRepository;

import java.util.Optional;

@UseCase
public class LoginServiceUseCase implements LoginUseCase {
    private final LoginUserRepository loginUserRepository;

    public LoginServiceUseCase(LoginUserRepository loginUserRepository) {
        this.loginUserRepository = loginUserRepository;
    }
    
    @Override
    public Optional<User> loginUser(String email, String password) {
        return this.loginUserRepository.login(email, password);
    }
}
