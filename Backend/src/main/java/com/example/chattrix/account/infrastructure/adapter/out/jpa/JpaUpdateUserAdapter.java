package com.example.chattrix.account.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.out.CreateUserRepository;
import com.example.chattrix.account.domain.port.out.UpdateUserRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaUpdateUserAdapter implements UpdateUserRepository {
    private final UserEntityRepository userEntityRepository;

    public JpaUpdateUserAdapter(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public User update(User user) {
        return this.userEntityRepository.save(UserEntity.fromDomain(user)).toDomain();
    }
}
