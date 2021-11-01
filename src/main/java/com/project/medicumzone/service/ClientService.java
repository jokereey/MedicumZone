package com.project.medicumzone.service;

import com.project.medicumzone.model.enitity.Client;
import com.project.medicumzone.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public void addNewClient(Client client){

    }
}
