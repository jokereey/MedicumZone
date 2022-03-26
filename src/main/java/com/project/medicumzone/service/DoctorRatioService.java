package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.io.dto.DoctorRatioDto;
import com.project.medicumzone.io.enitity.AppUser;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.enitity.DoctorRatio;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.repository.DoctorRatioRepository;
import com.project.medicumzone.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
@Slf4j
@AllArgsConstructor
public class DoctorRatioService {

    private final DoctorRatioRepository doctorRatioRepository;
    private final DoctorRepository doctorRepository;
    private final AppUserRepository appUserRepository;
    private final Clock clock = Clock.systemDefaultZone();

    public DoctorRatio addNew(DoctorRatioDto request){
        Doctor doctor =  doctorRepository.getById(request.getDoctorId());
        AppUser user = appUserRepository.findAppUserByUsername(request.getUsername());
        if(!alreadyRated(doctor,user)){
            DoctorRatio doctorRatio =  DoctorRatio.builder()
                    .ratioValue(request.getRatioValue())
                    .doctor(doctor)
                    .ratedBy(user.getId())
                    .createdAt(LocalDateTime.now(clock))
                    .comment(request.getComment())
                    .build();
            doctorRatioRepository.save(doctorRatio);

            return doctorRatio;
        } else{
            throw new ApiRequestException("This user has already rated the doctor");
        }

    }
    protected boolean alreadyRated(Doctor doctor, AppUser user){
        AtomicBoolean alreadyRated = new AtomicBoolean(false);
        doctor.getRatios().forEach(doctorRatio -> {
            if(doctorRatio.getRatedBy().equals( user.getId())){
                alreadyRated.set(true);
            }
        });
        return alreadyRated.getPlain();
    }
}
