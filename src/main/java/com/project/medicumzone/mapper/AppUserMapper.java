package com.project.medicumzone.mapper;

import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Authority;
import com.project.medicumzone.io.request.AppUserSignUpRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Component
public class AppUserMapper {

    private PasswordEncoder passwordEncoder;

    public AppUser.AppUserBuilder convertToAppUserBuilder(AppUserSignUpRequest request){
        return AppUser.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .PESEL(request.getPESEL())
                .phoneNumber(request.getPhoneNumber())
                .dob(request.getDob())
                .email(request.getEmail())
                .username(request.getEmail())
                .enabled(true)
                .password(passwordEncoder.encode(request.getPassword()));
    }
}
