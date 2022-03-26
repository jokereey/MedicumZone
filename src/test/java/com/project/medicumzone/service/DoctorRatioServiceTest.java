package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.dto.DoctorRatioDto;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.enitity.DoctorRatio;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.repository.DoctorRatioRepository;
import com.project.medicumzone.repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class DoctorRatioServiceTest {
    
    @Mock
    private  AppUserRepository appUserRepository;
    @Mock
    private DoctorRepository doctorRepository;
    @Mock
    private DoctorRatioRepository doctorRatioRepository;
    private DoctorRatioService underTest;

    @BeforeEach
    void setUp() {
        underTest = new DoctorRatioService(doctorRatioRepository,doctorRepository,appUserRepository);
    }

    @Test
    void shouldNotAddNewRatio() {
        //given
        var request =  createDto();
        given(appUserRepository.findAppUserByUsername(any())).willReturn(getAlreadyRatedUser());
        given(doctorRepository.getById(any())).willReturn(getDoctor());
        //when
        assertThatThrownBy(() ->underTest.addNew(request))
                .isInstanceOf(ApiRequestException.class)
                .hasMessageContaining("This user has already rated the doctor");
        //then
        then(doctorRatioRepository).shouldHaveNoInteractions();
    }

    @Test
    @Transactional
    void shouldAddNewRatio() {
        //given
        var request =  createDto();
        given(appUserRepository.findAppUserByUsername(any())).willReturn(getUser());
        given(doctorRepository.getById(any())).willReturn(getDoctor());
        //when
        DoctorRatio ratio = underTest.addNew(request);
        //then
        assertEquals(8L,ratio.getRatedBy());
        assertEquals(request.getComment(),ratio.getComment());
        assertEquals(request.getRatioValue(),ratio.getRatioValue());
        assertEquals(request.getDoctorId(),ratio.getDoctor().getId());
        then(doctorRatioRepository).should().save(any());
    }

    private DoctorRatioDto createDto(){
        return new DoctorRatioDto(1L,"example.user@gmail.com","Comment",4.5);
    }
    private Doctor getDoctor(){
        return Doctor.builder()
                .id(1L)
                .ratios(List.of(
                        new DoctorRatio(
                                1L,4.5,"Comment",1L, LocalDateTime.now(),null
                        )
                ))
                .build();
    }
    private AppUser getAlreadyRatedUser(){
        return AppUser.builder()
                .id(1L)
                .build();
    }
    private AppUser getUser(){
        return AppUser.builder()
                .id(8L)
                .build();
    }
}