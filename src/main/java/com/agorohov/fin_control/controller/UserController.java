package com.agorohov.fin_control.controller;

import com.agorohov.fin_control.dto.NewPassword;
import com.agorohov.fin_control.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/set_password")
    public void setPassword(@Valid @RequestBody NewPassword newPassword,
                            Authentication authentication) {
        String userEmail = authentication.getName();
        userService.setPassword(userEmail, newPassword);
    }
}
