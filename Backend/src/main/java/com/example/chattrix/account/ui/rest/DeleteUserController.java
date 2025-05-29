package com.example.chattrix.account.ui.rest;

import com.example.chattrix.account.domain.model.UserId;
import com.example.chattrix.account.domain.port.in.DeleteUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class DeleteUserController {
    private final DeleteUserUseCase deleteUserUseCase;

    public DeleteUserController(DeleteUserUseCase deleteUserUseCase) {
        this.deleteUserUseCase = deleteUserUseCase;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        UserId userId = new UserId(UUID.fromString(id));
        System.out.println(id);
        this.deleteUserUseCase.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
