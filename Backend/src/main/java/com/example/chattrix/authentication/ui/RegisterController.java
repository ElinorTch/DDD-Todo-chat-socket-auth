package com.example.chattrix.authentication.ui;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.ui.dto.UserDto;
import com.example.chattrix.authentication.domain.port.in.LoginUseCase;
import com.example.chattrix.authentication.domain.port.in.RegisterUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth/register")
public class RegisterController {
    private final RegisterUseCase registerUseCase;

    public RegisterController(RegisterUseCase registerUseCase) {
        this.registerUseCase = registerUseCase;
    }

    @PostMapping
    public ResponseEntity<UserDto> register(@RequestBody User userRequest) {
        User user = this.registerUseCase.register(userRequest.getEmail(), userRequest.getPassword());
        UserDto userResponse = new UserDto(user.getId().id().toString(), user.getUsername(), user.getEmail(), "");
        return ResponseEntity.ok(userResponse);
    }
}
