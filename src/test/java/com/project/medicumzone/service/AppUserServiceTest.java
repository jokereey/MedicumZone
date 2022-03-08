package com.project.medicumzone.service;

import com.project.medicumzone.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class AppUserServiceTest {

    private AppUserService underTest;
    private PasswordEncoder passwordEncoder;
    private AppUserRepository appUserRepository;

    @BeforeEach
    void setUp() {
        underTest =  new AppUserService(appUserRepository, passwordEncoder);
    }

    @Test
    void name() {

    }
}