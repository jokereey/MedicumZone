package com.project.medicumzone.service;

import com.project.medicumzone.error.ApiRequestException;
import com.project.medicumzone.model.enitity.AppUser;
import com.project.medicumzone.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }

    public void addNewUser(AppUser appUser) {
        if(appUserRepository.existsByEmail(appUser.getEmail())){
            throw new ApiRequestException("This user already exists.");
        }else{
            appUserRepository.save(appUser);
        }
    }
}
