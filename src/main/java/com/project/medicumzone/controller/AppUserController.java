package com.project.medicumzone.controller;

import com.project.medicumzone.service.AppUserService;
import com.project.medicumzone.io.request.AppUserSignUpRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
@RequestMapping("/api/users")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    private final AppUserService appUserService;


    @PostMapping
    public ResponseEntity<String> addNewUser(@RequestBody @Valid AppUserSignUpRequest request){
        log.info("Incoming request with main credentials: " + request);
        appUserService.addNewUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
