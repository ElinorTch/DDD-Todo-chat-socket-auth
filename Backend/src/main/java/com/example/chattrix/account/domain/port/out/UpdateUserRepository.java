package com.example.chattrix.account.domain.port.out;

import com.example.chattrix.account.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateUserRepository {
    User update(User user);
}
