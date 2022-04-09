package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.request.AppointmentRequest;
import com.project.medicumzone.io.request.NewClinicRequest;
import com.project.medicumzone.repository.CityRepository;
import com.project.medicumzone.repository.ClinicRepository;
import com.project.medicumzone.service.contract.HourCheck;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class ClinicService implements HourCheck {

    private final ClinicRepository clinicRepository;
    private final CityRepository cityRepository;

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public void addNewClinic(NewClinicRequest request) {
        var city = cityRepository.selectCityByName(request.getCity());
        if (city.isEmpty()) {
            throw new ApiRequestException("This city is out of our scope.");
        }
        Clinic newClinic = new Clinic(request.getClinicName(),
                request.getStreetName(),
                request.getZipCode(),
                city.get());
        clinicRepository.save(newClinic);
        log.info("New clinic has been added.");
    }

    public boolean isAvailableAtThisTime(AppointmentRequest appointmentRequest) {
        var clinicId = appointmentRequest.getClinicId();
        Clinic clinic = clinicRepository.getById(clinicId);
        var requestHour = appointmentRequest.getDate().getHour();
        var requestMinute = appointmentRequest.getDate().getMinute();
        if (requestHour == clinic.getCloseHour()) {
            return requestMinute <= 0;
        }
        return requestHour >= clinic.getOpenHour() && requestHour <= clinic.getCloseHour();
    }

    public boolean existsById(Long id) {
        return clinicRepository.existsById(id);
    }

    public Long getNumberOfClinics() {
        return clinicRepository.count();
    }


    public Clinic getById(Long clinicId) {
        return clinicRepository.getById(clinicId);
    }
}
