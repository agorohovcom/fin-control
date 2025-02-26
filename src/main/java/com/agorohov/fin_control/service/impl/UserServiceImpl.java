package com.agorohov.fin_control.service.impl;

import com.agorohov.fin_control.dto.NewPassword;
import com.agorohov.fin_control.entity.UserEntity;
import com.agorohov.fin_control.exception.ForbiddenException;
import com.agorohov.fin_control.mapper.AppMapper;
import com.agorohov.fin_control.repository.UserRepository;
import com.agorohov.fin_control.service.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final AppMapper appMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder encoder, AppMapper appMapper) {
        this.userRepository = userRepository;
        this.encoder = encoder;
        this.appMapper = appMapper;
    }

    @Override
    public void setPassword(String userEmail, NewPassword newPassword) {
        UserEntity userEntity = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Нет пользователя с логином " + userEmail));

        if (!encoder.matches(newPassword.getCurrentPassword(), userEntity.getPassword())) {
            throw new ForbiddenException("Текущий пароль указан неверно");
        }

        userEntity.setPassword(encoder.encode(newPassword.getNewPassword()));
        userRepository.save(userEntity);
    }
}
