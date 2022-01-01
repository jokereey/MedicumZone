package com.project.medicumzone.ui.controller;

import com.project.medicumzone.io.enitity.Client;
import com.project.medicumzone.service.ClientService;
import com.project.medicumzone.ui.model.request.NewClientRequestModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private final ClientService clientService;

    @PostMapping
    public void addNewClient(@Valid @RequestBody NewClientRequestModel newClient){
        clientService.addNewClient(newClient);
    }


}
