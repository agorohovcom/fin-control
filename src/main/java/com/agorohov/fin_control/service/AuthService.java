package com.agorohov.fin_control.service;

import com.agorohov.fin_control.dto.Register;

public interface AuthService {
    boolean login(String email, String password);

    boolean register(Register register);
}
