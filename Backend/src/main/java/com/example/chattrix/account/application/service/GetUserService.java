package com.example.chattrix.account.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.GetUserUseCase;
import com.example.chattrix.account.domain.port.out.GetUserRepository;
import com.example.chattrix.annotation.UseCase;

import java.util.Optional;

@UseCase
public class GetUserService implements GetUserUseCase {
    private final GetUserRepository getUserRepository;

    public GetUserService(GetUserRepository getUserRepository) {
        this.getUserRepository = getUserRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String username) {
        return this.getUserRepository.findByEmail(username);
    }

}
