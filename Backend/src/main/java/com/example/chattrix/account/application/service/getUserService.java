package com.example.chattrix.account.application.service;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;
import com.example.chattrix.account.domain.port.in.GetUserUseCase;
import com.example.chattrix.account.domain.port.out.GetUserRepository;

import java.util.ArrayList;
import java.util.Optional;

@UseCase
public class getUserService implements GetUserUseCase {
    private final GetUserRepository getUserRepository;

    public getUserService(GetUserRepository getUserRepository) {
        this.getUserRepository = getUserRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String username) {
        return this.getUserRepository.findByEmail(username);
    }

}
