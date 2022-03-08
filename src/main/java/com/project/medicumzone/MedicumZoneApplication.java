package com.project.medicumzone;

import com.project.medicumzone.config.TwilioConfig;
import com.project.medicumzone.io.enitity.City;
import com.project.medicumzone.io.enitity.Clinic;
import com.project.medicumzone.io.enitity.Doctor;
import com.project.medicumzone.io.enitity.Specialization;
import com.project.medicumzone.io.id.SpecializationID;
import com.project.medicumzone.repository.DoctorRatioRepository;
import com.project.medicumzone.repository.DoctorRepository;
import com.project.medicumzone.twilio.SmsRequest;
import com.project.medicumzone.twilio.TwilioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.vault.config.VaultAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.List;

@SpringBootApplication
@Slf4j
public class MedicumZoneApplication implements CommandLineRunner {


    private final TwilioConfig twilioConfig;
    private final TwilioService service;
    private final DoctorRepository doctorRepository;
    private final DoctorRatioRepository doctorRatioRepository;

    public MedicumZoneApplication(TwilioConfig twilioConfig, TwilioService service, DoctorRepository doctorRepository, DoctorRatioRepository doctorRatioRepository) {
        this.twilioConfig = twilioConfig;
        this.service = service;
        this.doctorRepository = doctorRepository;
        this.doctorRatioRepository = doctorRatioRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(MedicumZoneApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        // doctorRatioRepository.deleteAll();
        //doctorRepository.save(new Doctor("Janusz ","Walczuk",new Clinic("Kliniczka","KAzimierza","30-072",new City("Kraków"))));
    }
}
