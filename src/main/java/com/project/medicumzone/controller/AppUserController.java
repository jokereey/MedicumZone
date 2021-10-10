package com.project.medicumzone.controller;

import com.project.medicumzone.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;
}
