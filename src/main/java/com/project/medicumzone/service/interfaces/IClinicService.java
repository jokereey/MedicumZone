package com.project.medicumzone.service.interfaces;

import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.request.NewClinicRequestModel;

import java.util.List;

public interface IClinicService {
    List<Clinic> getAllClinics();
    void addNewClinic(NewClinicRequestModel clinicToAdd);
}
