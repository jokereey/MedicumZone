package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.repository.ClinicRepository;
import com.project.medicumzone.service.interfaces.IClinicService;
import com.project.medicumzone.io.request.NewClinicRequestModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClinicService implements IClinicService {

    private final ClinicRepository clinicRepository;


    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public void addNewClinic(NewClinicRequestModel clinicToAdd) {
        String clinicName = clinicToAdd.getClinicName();
        if (clinicRepository.findClinicByClinicNameEquals(clinicName).isPresent())
            return;
        else{
            Clinic newClinic = new Clinic(clinicToAdd.getClinicName(), clinicToAdd.getStreetName(), clinicToAdd.getZipCode(), new City(clinicToAdd.getCity()));
            clinicRepository.save(newClinic);
            log.info("New clinic has been added.");
        }
    }

    public Long getNumberOfClinics(){
        return clinicRepository.count();
    }
}
