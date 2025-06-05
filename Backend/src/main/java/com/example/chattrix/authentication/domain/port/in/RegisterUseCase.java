package com.example.chattrix.authentication.domain.port.in;

import com.example.chattrix.account.domain.model.User;
import org.springframework.stereotype.Component;


public interface  RegisterUseCase {
    User register(String username, String password);
}
