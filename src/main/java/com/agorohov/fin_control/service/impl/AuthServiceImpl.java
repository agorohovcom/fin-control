package com.agorohov.fin_control.service.impl;

import com.agorohov.fin_control.dto.Register;
import com.agorohov.fin_control.entity.UserEntity;
import com.agorohov.fin_control.mapper.AppMapper;
import com.agorohov.fin_control.repository.UserRepository;
import com.agorohov.fin_control.service.AuthService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    // TODO сделать зависимость от UserDetailsService и создать бин?
    private final CustomUserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppMapper mapper;

    public AuthServiceImpl(CustomUserDetailsService userDetailsService,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           AppMapper mapper) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.mapper = mapper;
    }

    @Override
    public boolean login(String email, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);
        return passwordEncoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(Register register) {
        Optional<UserEntity> findUser = userRepository.findByEmail(register.getEmail());
        if (findUser.isPresent()) {
            return false;
        }
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        userRepository.save(mapper.registerToUserEntity(register));
        return true;
    }
}
