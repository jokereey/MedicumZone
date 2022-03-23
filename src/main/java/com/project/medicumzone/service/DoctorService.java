package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiException;
import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.enitity.DoctorSchedule;
import com.project.medicumzone.repository.DoctorRepository;
import com.project.medicumzone.service.contract.HourCheck;
import com.project.medicumzone.service.contract.Translator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class DoctorService  implements HourCheck {

    private final DoctorRepository doctorRepository;
    private final Translator translator;
    public List<Doctor> getAll(){
        return doctorRepository.findAll();
    }
    public boolean existsById(Long id){
        return doctorRepository.existsById(id);
    }


    public boolean hourCheck(LocalDateTime appointmentDate,Long... ids) {
        var doctorId = ids[1];
        var clinicId = ids[0];
        Doctor doctor = doctorRepository.getById(doctorId);
        var requestHour = appointmentDate.getHour();
        var requestMinute = appointmentDate.getMinute();
        var requestDay = translator.translate(appointmentDate.getDayOfWeek().name());
        DoctorSchedule doctorSchedule = doctor.getClinicSchedules()
                .stream()
                .filter(schedule -> Objects.equals(schedule.getClinic().getClinicId(), clinicId))
                .filter(schedule -> Objects.equals(schedule.getWeekDay().getDayName(),requestDay))
                .findFirst().orElseThrow(() ->new ApiRequestException("No matching clinic"));
        if(requestHour == appointmentDate.getHour()){
            return requestMinute <=0;
        }
        return requestHour >= doctorSchedule.getFromHour() && requestHour<= doctorSchedule.getEndHour();

    }
}
