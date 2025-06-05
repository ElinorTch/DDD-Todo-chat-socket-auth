package com.example.chattrix.authentication.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.application.service.CreateUserService;
import com.example.chattrix.account.application.service.GetUserService;
import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.ui.dto.UserDto;
import com.example.chattrix.authentication.domain.port.out.LoginUserRepository;
import com.example.chattrix.authentication.domain.port.out.RegisterUserRepository;
import com.example.chattrix.config.PasswordConfig;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
public class RegisterUserRepositoryAdapter implements RegisterUserRepository {
    private final CreateUserService createUserService;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserRepositoryAdapter(CreateUserService createUserService, PasswordEncoder passwordEncoder) {
        this.createUserService = createUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(String email, String password) {
        User user = new User("", email, passwordEncoder.encode(CharBuffer.wrap(password)));
        return this.createUserService.createUser(user);
    }
}
