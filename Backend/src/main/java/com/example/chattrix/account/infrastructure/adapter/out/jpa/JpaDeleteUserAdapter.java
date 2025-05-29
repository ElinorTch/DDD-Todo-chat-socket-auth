package com.example.chattrix.account.infrastructure.adapter.out.jpa;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;
import com.example.chattrix.account.domain.port.out.CreateUserRepository;
import com.example.chattrix.account.domain.port.out.DeleteUserRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaDeleteUserAdapter implements DeleteUserRepository {
    private final UserEntityRepository userEntityRepository;

    public JpaDeleteUserAdapter(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    @Override
    public void deleteById(UserId id) {
        this.userEntityRepository.deleteById(id.id());
    }
}
