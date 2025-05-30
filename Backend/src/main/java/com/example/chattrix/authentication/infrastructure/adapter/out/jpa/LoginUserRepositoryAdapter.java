package com.example.chattrix.authentication.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.application.service.GetUserService;
import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.authentication.domain.port.out.LoginUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginUserRepositoryAdapter implements LoginUserRepository {
    private final GetUserService getUserService;
    private final PasswordEncoder passwordEncoder;

    public LoginUserRepositoryAdapter(GetUserService getUserService, PasswordEncoder passwordEncoder) {
        this.getUserService = getUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> user = getUserService.getUserByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}
