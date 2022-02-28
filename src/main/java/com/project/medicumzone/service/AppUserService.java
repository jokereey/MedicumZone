package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Authority;
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
    private PasswordEncoder passwordEncoder;

    public List<AppUser> getAllUsers() {
        return appUserRepository.findAll();
    }

    public void addNewUser(AppUserSignUpRequest request) {
        if (appUserRepository.existsByEmail(request.getEmail())) {
            throw new ApiRequestException("This user already exists.");
        } else {
            List<Authority> authorityList = new ArrayList<>();
            authorityList.add(createAuthority("USER", "User role"));
            String encodedPassword = passwordEncoder.encode(request.getPassword());
            AppUser newUser = new AppUser(
                    request.getName(),
                    request.getSurname(),
                    request.getEmail(),
                    encodedPassword,
                    request.getEmail(),
                    request.getDob(),
                    request.getPhoneNumber()
            );
            newUser.setEnabled(true);
            newUser.setAuthorities(authorityList);
            appUserRepository.save(newUser);
            log.info("New user has been added.");
        }
    }

    private Authority createAuthority(String roleCode, String roleDescription) {
        Authority authority = new Authority();
        authority.setRoleCode(roleCode);
        authority.setRoleDescription(roleDescription);
        return authority;
    }
}
