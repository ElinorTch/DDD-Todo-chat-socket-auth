package com.example.chattrix.account.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.out.CreateUserRepository;
import com.example.chattrix.account.domain.port.out.GetUserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JpaGetUserAdapter implements GetUserRepository {
    private final UserEntityRepository userEntityRepository;

    public JpaGetUserAdapter(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public Optional<User> findByEmailAndPassword(String email, String password) {
        return this.userEntityRepository.findByEmail(email);
    }
}
