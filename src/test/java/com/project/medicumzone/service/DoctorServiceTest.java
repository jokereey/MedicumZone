package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.enitity.DoctorSchedule;
import com.project.medicumzone.io.enitity.WeekDay;
import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.repository.DoctorRepository;
import com.project.medicumzone.service.contract.Translator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class DoctorServiceTest {
    
    private DoctorService underTest;
    
    @Mock
    DoctorRepository doctorRepository;
    @Mock
    Translator translator;

    @BeforeEach
    void setUp() {
        underTest = new DoctorService(doctorRepository,translator);
    }

    @Test
    void itShouldName() {
        //Given
        var clinic =getClinic();
        var doctor = getDoctor();
        assignSchedule(doctor,clinic);
        given(doctorRepository.getById(doctor.getId())).willReturn(doctor);
        given(translator.translate(any())).willReturn("Wtorek");
        //When
        boolean result = underTest.hourCheck(request());
        //Then
        Assertions.assertTrue(result);

    }

    private Doctor getDoctor(){
        return Doctor.builder()
                .id(1L)
                .name("test")
                .surname("test")
                .clinicSchedules(new HashSet<>())
                .build();
    }
    private Clinic getClinic(){
        return Clinic.builder()
                .clinicId(1L)
                .clinicName("Test Clinic")
                .closeHour(20)
                .openHour(10)
                .doctorSchedules(new ArrayList<>())
                .build();
    }
    private void assignSchedule(Doctor doctor, Clinic clinic){
        WeekDay weekDay = new WeekDay("Wtorek");
        DoctorSchedule doctorSchedule =  new DoctorSchedule(
                doctor,
                weekDay,
                clinic,
                12,
                15
        );
        doctor.getClinicSchedules().add(doctorSchedule);
        clinic.getDoctorSchedules().add(doctorSchedule);
    }
    private LocalDateTime createCorrectAppointmentDate(){
       return LocalDateTime.of(2022,3,24,15,30);
    }
    private AppointmentRequest request (){
        return  new AppointmentRequest(
                1L,
                1L,
                1L,
                createCorrectAppointmentDate()
        );
    }
}
