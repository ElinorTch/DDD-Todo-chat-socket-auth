package com.example.chattrix.authentication.domain.port.out;

import com.example.chattrix.account.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterUserRepository {
    User register(String email, String password);
}
