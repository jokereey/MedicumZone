package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.io.request.NewClinicRequest;
import com.project.medicumzone.repository.CityRepository;
import com.project.medicumzone.repository.ClinicRepository;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ClinicServiceTest {

    private ClinicService underTest;

    @Mock
    private ClinicRepository clinicRepository;
    @Mock
    CityRepository cityRepository;

    private final City city = new City("Kraków");

    @BeforeEach
    void setUp() {
        underTest = new ClinicService(clinicRepository,cityRepository);
    }

    @Test
    void itShouldAddNewClinic() {
        //Given
        var request = createNewClinicRequest();
       given(cityRepository.selectCityByName(request.getCity())).willReturn(Optional.of(city));
        //When
        underTest.addNewClinic(request);
        //Then
        then(clinicRepository).should().save(any());

    }

    @Test
    void itShouldThrowWhenCityIsOutOfScope() {
        //Given
        var request = createNewClinicRequest();
        given(cityRepository.selectCityByName(request.getCity())).willReturn(Optional.empty());
        //When
        Assertions.assertThatThrownBy(() ->underTest.addNewClinic(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("This city is out of our scope.");
        //Then
        then(clinicRepository).shouldHaveNoMoreInteractions();

    }

    @Test
    void itShouldBeAvailable() {
        //Given
        var request =  appointmentRequest();
        given(clinicRepository.getById(request.getClinicId())).willReturn(getClinic());
        //When
        var available = underTest.isAvailableAtThisTime(request);
        //Then
        Assertions.assertThat(available).isTrue();
    }
    @Test
    void itShouldNotBeAvailable() {
        //Given
        var request =  appointmentRequest();
        request.setDate(LocalDateTime.of(2022,6,3,19,30));
        given(clinicRepository.getById(request.getClinicId())).willReturn(getClinic());
        //When
        var available = underTest.isAvailableAtThisTime(request);
        //Then
        Assertions.assertThat(available).isFalse();
    }
    @Test
    void itShouldNotBeAvailableIfHoursAreEqual() {
        //Given
        var request =  appointmentRequest();
        request.setDate(LocalDateTime.of(2022,6,3,18,30));
        given(clinicRepository.getById(request.getClinicId())).willReturn(getClinic());
        //When
        var available = underTest.isAvailableAtThisTime(request);
        //Then
        Assertions.assertThat(available).isFalse();
    }


    @Test
    void itShouldShouldGetAllClinics() {
        //Given
        //When
        underTest.getAllClinics();
        //Then
        then(clinicRepository).should().findAll();
    }

    @Test
    void itShouldNumberOfClinics() {
        //Given
        //When
        underTest.getNumberOfClinics();
        //Then
        then(clinicRepository).should().count();
    }
    @Test
    void itShouldgetClinicById() {
        //Given
        var id = 5L;
        //When
        underTest.getById(id);
        //Then
        then(clinicRepository).should().getById(5L);
    }
    @Test
    void itShouldCheckIfExistsById() {
        //Given
        var id =5L;
        //When
        underTest.existsById(id);
        //Then
        then(clinicRepository).should().existsById(5L);
    }

  private NewClinicRequest createNewClinicRequest(){
        return NewClinicRequest.builder()
                .city("Kraków")
                .clinicName("Clinic")
                .streetName("Street name")
                .zipCode("30-072")
                .build();
  }
  private Clinic getClinic(){
        return Clinic.builder()
                .clinicId(1L)
                .doctorSchedules(Lists.emptyList())
                .clinicName("Clinic")
                .openHour(6)
                .closeHour(18)
                .city(city)
                .build();
  }
  private AppointmentRequest appointmentRequest(){
        return  new AppointmentRequest(1L,
                1L,
                1L,
                LocalDateTime.of(2022,6,3,10,30));
  }
}
