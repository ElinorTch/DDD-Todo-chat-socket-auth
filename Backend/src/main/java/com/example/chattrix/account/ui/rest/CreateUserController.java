package com.example.chattrix.account.ui.rest;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.domain.port.in.CreateUserUseCase;
import com.example.chattrix.account.ui.dto.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class CreateUserController {
    private final CreateUserUseCase createUserUseCase;

    public CreateUserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserDto> create(@RequestBody User userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword());
        createUserUseCase.createUser(user);
        UserDto userResponse = new UserDto(user.getId().id().toString(), user.getUsername(), user.getEmail(), "");
        return ResponseEntity.ok(userResponse);
    }
}
