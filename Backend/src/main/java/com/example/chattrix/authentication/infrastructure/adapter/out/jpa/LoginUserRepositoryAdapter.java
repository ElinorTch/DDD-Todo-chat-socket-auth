package com.example.chattrix.authentication.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.application.service.GetUserService;
import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.authentication.domain.port.out.LoginUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserRepositoryAdapter implements LoginUserRepository {
    private final GetUserService getUserService;

    public LoginUserRepositoryAdapter(GetUserService getUserService) {
        this.getUserService = getUserService;
    }

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> user = getUserService.getUserByEmail(email);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }
}
