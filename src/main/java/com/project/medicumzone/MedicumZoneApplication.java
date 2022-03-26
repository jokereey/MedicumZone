package com.project.medicumzone;

import com.project.medicumzone.config.TwilioConfig;
import com.project.medicumzone.io.enitity.*;
import com.project.medicumzone.io.id.SpecializationID;
import com.project.medicumzone.repository.*;
import com.project.medicumzone.twilio.TwilioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;

@SpringBootApplication
@Slf4j
@Transactional
public class MedicumZoneApplication implements CommandLineRunner {


    private final TwilioConfig twilioConfig;
    private final TwilioService service;
    private final DoctorRepository doctorRepository;
    private final DoctorRatioRepository doctorRatioRepository;
    private final ClinicRepository clinicRepository;
    private final WeekDayRepository weekDayRepository;
    private final ScheduleRepository scheduleRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;
    private final SpecializationRepository specializationRepository;


    public MedicumZoneApplication(TwilioConfig twilioConfig, TwilioService service, DoctorRepository doctorRepository, DoctorRatioRepository doctorRatioRepository, ClinicRepository clinicRepository, WeekDayRepository weekDayRepository, ScheduleRepository scheduleRepository, DoctorSpecializationRepository doctorSpecializationRepository, SpecializationRepository specializationRepository) {
        this.twilioConfig = twilioConfig;
        this.service = service;
        this.doctorRepository = doctorRepository;
        this.doctorRatioRepository = doctorRatioRepository;
        this.clinicRepository = clinicRepository;
        this.weekDayRepository = weekDayRepository;
        this.scheduleRepository = scheduleRepository;

        this.doctorSpecializationRepository = doctorSpecializationRepository;
        this.specializationRepository = specializationRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MedicumZoneApplication.class, args);

    }

    @Override

    public void run(String... args) throws Exception {


//
//        WeekDay weekDay = weekDayRepository.getById(1L);
//        Clinic clinic = clinicRepository.getById(3L);
//        Doctor doctor = doctorRepository.getById(5L);
//        DoctorSchedule doctorSchedule = new DoctorSchedule(
//                doctor,weekDay,clinic,8d,10d
//        );
//        doctor.getClinicSchedules().add(doctorSchedule);
//        clinic.getDoctorSchedules().add(doctorSchedule);
//
//        doctorRepository.save(doctor);

        var doctor = doctorRepository.getById(4L);
        System.out.println(doctor.getName());
        System.out.println(doctor.getSpecializations().get(0).getDoctorSpecialization().getName());
        doctor.getClinicSchedules().forEach(schedule ->{
            System.out.println(schedule.getClinic().getClinicName() + " " +schedule.getWeekDay().getDayName() + " " + schedule.getFromHour() +"-"+schedule.getEndHour());

        });


////        Doctor doctor = new Doctor("Tadeusz","Biedroń",)\
//        Doctor doctor = doctorRepository.getById(4L);
//        DoctorSpecialization doctorSpecialization = doctorSpecializationRepository.getById(13L);
//        Specialization specialization = new Specialization(new SpecializationID(doctor.getId(), doctorSpecialization.getId()));
//        specialization.setDoctor(doctor);
//        specialization.setDoctorSpecialization(doctorSpecialization);
//        var flushed = specializationRepository.saveAndFlush(specialization);
//         doctor.getSpecializations().add(flushed);
//        doctorRepository.save(doctor);

    }
}
