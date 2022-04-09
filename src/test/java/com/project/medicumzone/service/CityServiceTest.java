package com.project.medicumzone.service;

import com.project.medicumzone.repository.CityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@ExtendWith({MockitoExtension.class})
class CityServiceTest {

    private CityService underTest;

    @Mock
    private CityRepository cityRepository;

    @BeforeEach
    void setUp() {
        underTest = new CityService(cityRepository);
    }

    @Test
    void itShouldGetAllCities() {
        //Given
        //When
        underTest.getAllCities();
        //Then
        then(cityRepository).should().findAll();

    }
}
