package com.project.medicumzone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.medicumzone.io.dto.DoctorRatioDto;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.repository.CityRepository;
import com.project.medicumzone.repository.ClinicRepository;
import com.project.medicumzone.repository.DoctorRepository;
import com.project.medicumzone.service.DoctorRatioService;
import lombok.SneakyThrows;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.print.Doc;

import java.time.LocalDateTime;


import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class DoctorRatioControllerIT {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    AppUserRepository appUserRepository;
    @Autowired
    DoctorRatioService doctorRatioService;

    private static final String URL = "/api/doctor-ratio";


    @SneakyThrows
    @Test
    void itShouldAddDoctorRatio() {
        //Given
        appUserRepository.save(appUser());
        Doctor doctor = getDoctor();
        doctorRepository.saveAndFlush(doctor);
        //When
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getRequest())))
                .andExpect(status().isCreated());

    }

    @SneakyThrows
    @Test
    void itShouldAThrowWhenUserAlreadyRated() {
        //Given
        appUserRepository.save(appUser());
        Doctor doctor = getDoctor();
        doctorRepository.saveAndFlush(doctor);
        doctorRatioService.addNew(getRequest());
        //When
        mockMvc.perform(post(URL)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(getRequest())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("This user has already rated the doctor")));

    }

    private DoctorRatioDto getRequest() {
        return new DoctorRatioDto(1L, "user.example@gmail.com", "Really good one doctor", 4.5);
    }

    private Doctor getDoctor() {
        return Doctor.builder()
                .name("Janusz")
                .surname("Walczuk")
                .build();
    }

    private AppUser appUser() {
        return AppUser.builder()
                .name("user.example@gmail.com")
                .phoneNumber("123123132")
                .password("password")
                .email("email@email.com")
                .PESEL("002334354192")
                .username("user.example@gmail.com")
                .surname("surname")
                .dob(LocalDateTime.now())
                .build();
    }
}
