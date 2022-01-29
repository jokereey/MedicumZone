package com.project.medicumzone.ui.controller;

import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.service.AppUserService;
import com.project.medicumzone.ui.model.request.AppUserSignUpRequest;
import com.project.medicumzone.ui.model.response.SignUpResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@AllArgsConstructor
@RequestMapping("/api/users")
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class AppUserController {

    @Autowired
    private final AppUserService appUserService;


    @PostMapping("/add")
    public ResponseEntity<String> addNewUser(@RequestBody @Valid AppUserSignUpRequest request){
        log.info("Incoming request with main credentials: ");
        log.warn("email:" +request.getEmail());
        log.warn("surname:" +request.getSurname());
        appUserService.addNewUser(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
