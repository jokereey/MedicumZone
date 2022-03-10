package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.Client;
import com.project.medicumzone.io.request.NewClientRequestModel;
import com.project.medicumzone.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository clientRepository;


    public void addNewClient(NewClientRequestModel clientToAdd) {
        String phoneNumber = clientToAdd.getPhoneNumber();
        String email = clientToAdd.getEmail();

        Optional<Client> clientOptional = clientRepository.selectClientByPhoneNumberAndEmail(phoneNumber, email);
        if (clientOptional.isPresent())
            return;
        else {
            Client newClient = new Client(clientToAdd.getFirstName(), clientToAdd.getLastName(), clientToAdd.getPhoneNumber(), clientToAdd.getEmail());
            clientRepository.save(newClient);
            log.info("New Client has been added.");
        }
    }
}
