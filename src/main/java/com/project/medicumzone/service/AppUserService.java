package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Authority;
import com.project.medicumzone.mapper.AppUserMapper;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.io.request.AppUserSignUpRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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

    public AppUser addNewUser(AppUserSignUpRequest request) {
        if (!appUserRepository.existsByPESEL(request.getPESEL())) {
            if (appUserRepository.existsByEmail(request.getEmail())) {
                throw new ApiRequestException("User with email " + request.getEmail() + " has been already registered");
            } else {
                List<Authority> authorityList = new ArrayList<>();
                authorityList.add(createAuthority());
                AppUser.AppUserBuilder builder = mapper.convertToAppUserBuilder(request);
                builder.authorities(authorityList);
                AppUser newUser = builder.build();
                appUserRepository.save(newUser);
                log.info("User has been registered successfully.");
                return newUser;
            }
        } else {
            throw new ApiRequestException("User with PESEL " + request.getPESEL() + " has been already registered");
        }
    }
    public boolean existsById(Long id){
        return appUserRepository.existsById(id);
    }

    private Authority createAuthority() {
        Authority authority = new Authority();
        authority.setRoleCode("USER");
        authority.setRoleDescription("User role");
        return authority;
    }

    public AppUser getById(Long userId) {
        return appUserRepository.getById(userId);
    }
}
