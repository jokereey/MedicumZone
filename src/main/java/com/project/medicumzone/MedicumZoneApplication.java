package com.project.medicumzone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication

public class MedicumZoneApplication {


    public static void main(String[] args) {
        SpringApplication.run(MedicumZoneApplication.class, args);
    }

    @PostConstruct
    protected void init() {
    }

}
