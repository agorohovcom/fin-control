package com.agorohov.fin_control.service.impl;

import com.agorohov.fin_control.entity.UserEntity;
import com.agorohov.fin_control.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity findUser = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Нет пользователя с логином " + email));
        return new CustomUserDetails(findUser);
    }
}
