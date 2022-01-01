package com.project.medicumzone.ui.controller;

import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/api/users")
public class AppUserController {

    @Autowired
    private final AppUserService appUserService;

    @PostMapping("/add")
    public ResponseEntity<String> addNewUser(@RequestBody AppUser appUser){
        appUserService.addNewUser(appUser);
        return new ResponseEntity<>(HttpStatus.CREATED)     ;
    }
}
