package com.example.chattrix.account.ui.rest;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.model.UserId;
import com.example.chattrix.account.domain.port.in.UpdateUserUseCase;
import com.example.chattrix.account.ui.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UpdateUserController {
    private final UpdateUserUseCase updateUserUseCase;

    public UpdateUserController(UpdateUserUseCase updateUserUseCase) {
        this.updateUserUseCase = updateUserUseCase;
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody User user) {
        UserId userId = new UserId(UUID.fromString(id));
        user.setId(userId);
        this.updateUserUseCase.updateUser(user);
        UserDto userResponse = new UserDto(user.getId().id().toString(), user.getUsername(), user.getEmail(), "");
        return ResponseEntity.ok(userResponse);
    }
}
