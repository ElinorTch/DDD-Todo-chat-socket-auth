package com.example.chattrix.account.ui.rest;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.GetUserUseCase;
import com.example.chattrix.account.ui.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class GetUserController {
    private final GetUserUseCase getUserUseCase;

    public GetUserController(GetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @GetMapping
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam(name = "email") String email) {
        Optional<User> user = this.getUserUseCase.getUserByEmail(email);
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UserDto userResponse = new UserDto(user.get().getId().id().toString(),user.get().getUsername(), user.get().getEmail(), "");
        return ResponseEntity.ok(userResponse);
    }
}
