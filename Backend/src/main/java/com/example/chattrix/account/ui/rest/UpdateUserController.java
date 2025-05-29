package com.example.chattrix.account.ui.rest;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;
import com.example.chattrix.account.domain.port.in.UpdateUserUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UpdateUserController {
    private final UpdateUserUseCase updateUserUseCase;

    public UpdateUserController(UpdateUserUseCase updateUserUseCase) {
        this.updateUserUseCase = updateUserUseCase;
    }

    @PatchMapping("{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
        UserId userId = new UserId(UUID.fromString(id));
        user.setId(userId);
        this.updateUserUseCase.updateUser(user);
    }
}
