package com.project.medicumzone.service;

import com.project.medicumzone.model.enitity.AppUser;
import com.project.medicumzone.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }

}
