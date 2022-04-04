package com.project.medicumzone;

import com.project.medicumzone.config.TwilioConfig;
import com.project.medicumzone.io.enitity.Appointment;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.repository.*;
import com.project.medicumzone.twilio.TwilioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootApplication
@Slf4j
@Transactional
public class MedicumZoneApplication implements CommandLineRunner {


    private final TwilioConfig twilioConfig;
    private final TwilioService service;
    private final DoctorRepository doctorRepository;
    private final AppUserRepository appUserRepository;
    private final DoctorRatioRepository doctorRatioRepository;
    private final AppointmentRepository appointmentRepository;
    private final ClinicRepository clinicRepository;
    private final WeekDayRepository weekDayRepository;
    private final ScheduleRepository scheduleRepository;
    private final DoctorSpecializationRepository doctorSpecializationRepository;
    private final SpecializationRepository specializationRepository;


    public MedicumZoneApplication(TwilioConfig twilioConfig, TwilioService service, DoctorRepository doctorRepository, AppUserRepository appUserRepository, DoctorRatioRepository doctorRatioRepository, AppointmentRepository appointmentRepository, ClinicRepository clinicRepository, WeekDayRepository weekDayRepository, ScheduleRepository scheduleRepository, DoctorSpecializationRepository doctorSpecializationRepository, SpecializationRepository specializationRepository) {
        this.twilioConfig = twilioConfig;
        this.service = service;
        this.doctorRepository = doctorRepository;
        this.appUserRepository = appUserRepository;
        this.doctorRatioRepository = doctorRatioRepository;
        this.appointmentRepository = appointmentRepository;
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



        var doctor = doctorRepository.getById(4L);
        var appUser = appUserRepository.getById(1L);
        var clinic = clinicRepository.getById(3L);
//        Appointment appointment = new Appointment(
//                doctor,
//                appUser,
//                clinic,
//                LocalDateTime.of(2022,4,16,10,30)
//        );
//        appUser.getAppointments().forEach(appointmentt ->{
//            System.out.println("Wizyty pacjenta " + appointmentt.getAppUser().getName() +" "+appointmentt.getAppUser().getSurname());
//            System.out.println("Adres: "+ appointmentt.getClinic().getClinicName() + "ul." +appointmentt.getClinic().getStreetName() );
//            System.out.println(appointmentt.getDoctor().getSpecializations().get(0).getDoctorSpecialization().getName() +" "+ appointmentt.getDoctor().getName() + appointment.getDoctor().getSurname());
//            System.out.println(appointmentt.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
//
//        });
           boolean res =appointmentRepository.existsByAppointmentDateAndDoctorAndClinic(LocalDateTime.of(2022,4,16,10,30),doctor,clinic );
        System.out.println(res);
         List<Clinic> clinics =  clinicRepository.findAllById(List.of(1L,2L,3L));
         clinics.forEach(clinicc ->{
             clinicc.setOpenHour(6);
             clinicc.setCloseHour(18);
         } );
         clinicRepository.flush();
//        doctor.getAppointments().add(appointment);
//        appUser.getAppointments().add(appointment);
//        clinic.getAppointments().add(appointment);
//        appointmentRepository.save(appointment);
//        System.out.println(doctor.getName());
//        System.out.println(doctor.getSpecializations().get(0).getDoctorSpecialization().getName());
//        doctor.getClinicSchedules().forEach(schedule ->{
//            System.out.println(schedule.getClinic().getClinicName() + " " +schedule.getWeekDay().getDayName() + " " + schedule.getFromHour() +"-"+schedule.getEndHour());
//
//        });


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
