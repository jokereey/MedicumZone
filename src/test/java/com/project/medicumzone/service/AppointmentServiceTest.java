package com.project.medicumzone.service;

import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.repository.AppointmentRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class AppointmentServiceTest {
    @Mock
    private AppUserService appUserService;
    @Mock
    private DoctorService doctorService;
    @Mock
    private ClinicService clinicService;
    @Mock
    private AppointmentRepository appointmentRepository;
    
    private AppointmentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new AppointmentService(appointmentRepository,appUserService,doctorService,clinicService);
    }

    @Test
    void itShouldName() {
        //Given
        //When
        //Then

    }
}
