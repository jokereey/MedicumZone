package com.project.medicumzone;

import com.project.medicumzone.model.enitity.AppUser;
import com.project.medicumzone.model.enitity.Authority;
import com.project.medicumzone.model.enitity.City;
import com.project.medicumzone.repository.AppUserRepository;
import com.project.medicumzone.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MedicumZoneApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private CityRepository cityRepository;

    public static void main(String[] args) {
        SpringApplication.run(MedicumZoneApplication.class, args);
    }
    @PostConstruct
    protected  void init (){
//        List<Authority> authorityList = new ArrayList<>();
//        authorityList.add(new Authority("USER","User role"));
//        authorityList.add(new Authority("ADMIN","Admin role"));
//        AppUser appUser = new AppUser();
//
        System.out.println("Dzien dobry testuje kod");

    }

}
