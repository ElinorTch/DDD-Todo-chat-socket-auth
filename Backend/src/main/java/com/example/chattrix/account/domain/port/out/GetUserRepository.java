package com.example.chattrix.account.domain.port.out;

import com.example.chattrix.account.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GetUserRepository {
    Optional<User> findByEmailAndPassword(String email, String password);
}
