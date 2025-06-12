package com.example.chattrix.authentication.ui;

import com.example.chattrix.account.domain.model.User;
import com.example.chattrix.account.ui.dto.UserDto;
import com.example.chattrix.authentication.domain.port.in.LoginUseCase;
import com.example.chattrix.config.UserAuthenticationProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/auth/login")
public class LoginController {
    private final LoginUseCase loginUseCase;
    private final UserAuthenticationProvider userAuthenticationProvider;

    public LoginController(LoginUseCase loginUseCase, UserAuthenticationProvider userAuthenticationProvider) {
        this.loginUseCase = loginUseCase;
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping
    public ResponseEntity<UserDto> login(@RequestBody User userRequest) {
        Optional<User> user = this.loginUseCase.loginUser(userRequest.getEmail(), userRequest.getPassword());
        if (user.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        UserDto userResponse = new UserDto(user.get().getId().id().toString(), user.get().getUsername(), user.get().getEmail(), "");
        userResponse.setToken(userAuthenticationProvider.createToken(userResponse));
        return ResponseEntity.ok(userResponse);
    }
}
