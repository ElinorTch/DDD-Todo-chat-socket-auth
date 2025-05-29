package com.example.chattrix.account.ui.rest;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.GetUserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class GetUserController {
    private final GetUserUseCase getUserUseCase;

    public GetUserController(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping("/getByEmail")
    public ResponseEntity<Optional<User>> getUserByEmail(@RequestBody User userDto) {
        Optional<User> user = this.getUserUseCase.getUserByEmail(userDto.getEmail());
        return ResponseEntity.ok(user);
    }
}
