package com.example.chattrix.account.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.out.CreateUserRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaCreateUserAdapter implements CreateUserRepository {
    private final UserEntityRepository userEntityRepository;

    public JpaCreateUserAdapter(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User save(User user) {
        userEntityRepository.save(UserEntity.fromDomain(user));
        return user;
    }

}
