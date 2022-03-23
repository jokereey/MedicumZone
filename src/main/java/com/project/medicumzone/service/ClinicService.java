package com.project.medicumzone.service;

import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.request.NewClinicRequestModel;
import com.project.medicumzone.repository.ClinicRepository;
import com.project.medicumzone.service.contract.HourCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClinicService implements HourCheck {

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
    public boolean hourCheck( LocalDateTime appointmentDate,Long... ids){
        var clinicId = ids[0];
        Clinic clinic = clinicRepository.getById(clinicId);
        var requestHour = appointmentDate.getHour();
        var requestMinute = appointmentDate.getMinute();
        if(requestHour == clinic.getCloseHour()){
            return requestMinute <= 0;
        }
        return requestHour >= clinic.getOpenHour() && requestHour<= clinic.getCloseHour();
    }

    public boolean existsById(Long id){
        return clinicRepository.existsById(id);
    }

    public Long getNumberOfClinics() {
        return clinicRepository.count();
    }


}
