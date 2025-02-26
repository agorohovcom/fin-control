package com.agorohov.fin_control.service;

import com.agorohov.fin_control.dto.NewPassword;

public interface UserService {

    void setPassword(String userEmail, NewPassword newPassword);
}
