package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Authority;
import com.project.medicumzone.mapper.AppUserMapper;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.io.request.AppUserSignUpRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserMapper mapper;


    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public void addNewUser(AppUserSignUpRequest request) {
        if(!appUserRepository.existsByPESEL(request.getPESEL())) {
            if (appUserRepository.existsByEmail(request.getEmail())) {
                throw new ApiRequestException("User with email "+ request.getEmail()+" hase been already registered");
            } else {
                List<Authority> authorityList = new ArrayList<>();
                authorityList.add(createAuthority("USER", "User role"));
                AppUser.AppUserBuilder builder = mapper.convertToAppUserBuilder(request);
                builder.authorities(authorityList);
                AppUser newUser = builder.build();
                appUserRepository.save(newUser);
                log.info("New user has been added.");
            }
        } else {
            throw new ApiRequestException("User with PESEL "+ request.getPESEL() +" hase been already registered");
        }
    }

    private Authority createAuthority(String roleCode, String roleDescription) {
        Authority authority = new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }
}
