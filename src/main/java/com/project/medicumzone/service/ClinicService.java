package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.request.NewClinicRequestModel;
import com.project.medicumzone.repository.ClinicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClinicService {

    private final ClinicRepository clinicRepository;


    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public void addNewClinic(NewClinicRequestModel clinicToAdd) {
        String clinicName = clinicToAdd.getClinicName();
        if (clinicRepository.findClinicByClinicNameEquals(clinicName).isPresent())
            return;
        else {
            Clinic newClinic = new Clinic(clinicToAdd.getClinicName(), clinicToAdd.getStreetName(), clinicToAdd.getZipCode(), new City(clinicToAdd.getCity()));
            clinicRepository.save(newClinic);
            log.info("New clinic has been added.");
        }
    }

    public boolean existsById(Long id){
        return clinicRepository.existsById(id);
    }

    public Long getNumberOfClinics() {
        return clinicRepository.count();
    }
}
