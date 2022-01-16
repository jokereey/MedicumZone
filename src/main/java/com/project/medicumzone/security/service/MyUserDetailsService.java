package com.project.medicumzone.security.service;

import com.project.medicumzone.error.UserNotFoundException;
import com.project.medicumzone.model.enitity.AppUser;
import com.project.medicumzone.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        log.info("Email: "+email);
        AppUser user = appUserRepository.findAppUserByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("This user does not exists!");
        }
        return user;
    }



}
