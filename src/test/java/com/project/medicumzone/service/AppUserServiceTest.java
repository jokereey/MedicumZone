package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.request.AppUserSignUpRequest;
import com.project.medicumzone.mapper.AppUserMapper;
import com.project.medicumzone.repository.AppUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

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
    void shouldThrowWhenPESELAlreadyExists() {
        //given
        AppUserSignUpRequest request = createRequest();
        //when
        Assertions.assertThatThrownBy(() ->underTest.addNewUser(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("User with email " + request.getEmail() + " has been already registered");
    }

    private AppUserSignUpRequest createRequest(){
        return  AppUserSignUpRequest.builder()
                .email("example@gmail.com")
                .password("Password123+")
                .PESEL("00561394568")
                .name("name")
                .surname("surname")
                .newsletter(true)
                .dob(LocalDateTime.now())
                .phoneNumber("123456789")
                .build();
    }
}
