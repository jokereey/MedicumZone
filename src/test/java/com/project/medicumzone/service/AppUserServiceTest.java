package com.project.medicumzone.service;

import com.project.medicumzone.mapper.AppUserMapper;
import com.project.medicumzone.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AppUserServiceTest {

    private AppUserService underTest;
    @Mock
    private AppUserRepository appUserRepository;
    @Mock
    private AppUserMapper mapper;

    @BeforeEach
    void setUp() {
        underTest = new AppUserService(appUserRepository, mapper);
    }

    @Test
    void name() {

    }
}