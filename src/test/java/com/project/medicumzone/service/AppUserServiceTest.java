package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.request.AppUserSignUpRequest;
import com.project.medicumzone.mapper.AppUserMapper;
import com.project.medicumzone.repository.AppUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.time.LocalDateTime;
import java.util.Collections;

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
        given(appUserRepository.existsByPESEL(any())).willReturn(true);
        //when
        Assertions.assertThatThrownBy(() ->underTest.addNewUser(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("User with PESEL "+ request.getPESEL() + " has been already registered");
    }

    @Test
    void shouldThrowWhenEmailAlreadyExists() {
        //given
        AppUserSignUpRequest request = createRequest();
        given(appUserRepository.existsByEmail(any())).willReturn(true);
        //when
        Assertions.assertThatThrownBy(() ->underTest.addNewUser(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("User with email " + request.getEmail() + " has been already registered");
    }
    @Test
    @Transactional
    void shouldAddNewAppUser() {
        //given
        AppUserSignUpRequest request = createRequest();
        given(appUserRepository.existsByEmail(any())).willReturn(false);
        given(appUserRepository.existsByPESEL(any())).willReturn(false);
        given(mapper.convertToAppUserBuilder(any())).willReturn(createAppUserBuilder());
        //when
        AppUser createdUser = underTest.addNewUser(request);
        //then
        then(appUserRepository).should().save(any());

        assertTrue(createdUser.isEnabled());
        assertEquals("example@gmail.com",createdUser.getEmail());
        assertEquals("name",createdUser.getName());
        assertEquals("surname",createdUser.getSurname());
        assertEquals(1,createdUser.getAuthorities().size());
        assertEquals("00561394568",createdUser.getPESEL());
        assertEquals("123321123",createdUser.getPhoneNumber());
        assertEquals(0,createdUser.getAppointments().size());

    }

    @Test
    void itShouldGetAllUsers() {
        //Given
        //When
        underTest.getAllUsers();
        //Then
        then(appUserRepository).should().findAll();

    }

    @Test
    void itShouldCheckIfUserExistsById() {
        //Given
        var id = 1L;
        //When
        underTest.existsById(id);
        //Then
        then(appUserRepository).should().existsById(id);

    }

    @Test
    void itShouldgetUserById() {
        //Given
        var id = 1L;
        //When
        underTest.getById(id);
        //Then
        then(appUserRepository).should().getById(id);

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
    private AppUser.AppUserBuilder createAppUserBuilder(){
        return  AppUser.builder()
                .username("example@gmail.com")
                .email("example@gmail.com")
                .password("password123@")
                .PESEL("00561394568")
                .dob(LocalDateTime.now())
                .enabled(true)
                .name("name")
                .phoneNumber("123321123")
                .appointments(Collections.emptyList())
                .surname("surname");
    }
}
