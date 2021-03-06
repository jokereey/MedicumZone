package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.repository.AppointmentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verify;

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
        underTest = new AppointmentService(appointmentRepository, appUserService, doctorService, clinicService);
    }

    @Test
    void itShouldSaveAppointment() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(true);
        given(clinicService.isAvailableAtThisTime(request)).willReturn(true);
        given(doctorService.isAvailableAtThisTime(request)).willReturn(true);
        given(appointmentRepository.existsByAppointmentDateAndDoctorAndClinic(
              any(),any(),any()
        )).willReturn(false);
        given(doctorService.getById(request.getDoctorId())).willReturn(new Doctor());
        given(appUserService.getById(request.getUserId())).willReturn(new AppUser());
        given(clinicService.getById(request.getClinicId())).willReturn(new Clinic());

        //When
        underTest.addNewAppointment(request);
        //Then
        then(appointmentRepository).should().saveAndFlush(any());
    }

    @Test
    void itShouldThrowWhenDateIsTaken() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(true);
        given(clinicService.isAvailableAtThisTime(request)).willReturn(true);
        given(doctorService.isAvailableAtThisTime(request)).willReturn(true);
        given(appointmentRepository.existsByAppointmentDateAndDoctorAndClinic(
                any(),any(),any()
        )).willReturn(true);
        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewAppointment(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("This date is already taken");
        //Then
        then(appointmentRepository).shouldHaveNoMoreInteractions();
    }

    @Test
    @DisplayName("It should throw when appointment date is incorrect - clinic is closed")
    void itShouldThrowWhenRequestHourFailsClinic() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(true);
        given(clinicService.isAvailableAtThisTime(request)).willReturn(false);
        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewAppointment(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("Appointment date is incorrect. Either clinic is closed or the doctor is not available at this time.");
        //Then
    }
    @Test
    @DisplayName("It should throw when appointment date is incorrect - Doctor is not available")
    void itShouldThrowWhenRequestHourFailsDoctor() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(true);
        given(clinicService.isAvailableAtThisTime(request)).willReturn(true);
        given(doctorService.isAvailableAtThisTime(request)).willReturn(false);
        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewAppointment(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("Appointment date is incorrect. Either clinic is closed or the doctor is not available at this time.");
        //Then
    }

    @Test
    void itShouldThrowWhenRequestContainInvalidUserData() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(false);
        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewAppointment(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("Request contains data that don't exist.");
        //Then

    }
    @Test
    void itShouldThrowWhenRequestContainInvalidDoctorData() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(false);

        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewAppointment(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("Request contains data that don't exist.");
        //Then

    }
    @Test
    void itShouldThrowWhenRequestContainInvalidClinicData() {
        //Given
        var request =  createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(false);
        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewAppointment(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("Request contains data that don't exist.");
        //Then

    }

    @Test
    void shouldNotValidateRequestWhenDoctorDoesNotExists() {
        //Given
        var request = createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(false);
        //When
        boolean isValid = underTest.validateRequestByExistence(request);
        //Then
        Assertions.assertThat(isValid).isFalse();

    }
    @Test
    void shouldNotValidateRequestWhenUserDoesNotExists() {
        //Given
        var request = createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        //When
        boolean isValid = underTest.validateRequestByExistence(request);
        //Then
        Assertions.assertThat(isValid).isFalse();

    }
    @Test
    void shouldNotValidateRequestWhenClinicDoesNotExists() {
        //Given
        var request = createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(false);
        //When
        boolean isValid = underTest.validateRequestByExistence(request);
        //Then
        Assertions.assertThat(isValid).isFalse();

    }

    @Test
    void shouldValidateRequest() {
        //Given
        var request = createAppointmentRequest();
        given(appUserService.existsById(request.getUserId())).willReturn(true);
        given(doctorService.existsById(request.getDoctorId())).willReturn(true);
        given(clinicService.existsById(request.getClinicId())).willReturn(true);
        //When
        boolean isValid = underTest.validateRequestByExistence(request);
        //Then
        Assertions.assertThat(isValid).isTrue();
    }

    private AppointmentRequest createAppointmentRequest(){
        return new AppointmentRequest(1L,4L,3L, LocalDateTime.of(2022,1,1,16,30));
    }
}
