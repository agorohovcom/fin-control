package com.agorohov.fin_control.dto;

import com.agorohov.fin_control.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Register {

    @Size(min = 4, max = 32)
    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String email;
    @Size(min = 8, max = 16)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Register() {
    }

    public Register(String email, String password, Role role) {
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
