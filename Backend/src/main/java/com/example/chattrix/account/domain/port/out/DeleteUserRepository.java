package com.example.chattrix.account.domain.port.out;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;
import org.springframework.stereotype.Repository;

@Repository
public interface DeleteUserRepository {
    void deleteById(UserId id);
}
