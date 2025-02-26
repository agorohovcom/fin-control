package com.agorohov.fin_control.dto;

import jakarta.validation.constraints.Size;

public class Login {

    @Size(min = 4, max = 32)
    private String email;
    @Size(min = 8, max = 16)
    private String password;

    public Login() {
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
