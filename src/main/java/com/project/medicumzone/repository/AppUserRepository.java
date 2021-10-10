package com.project.medicumzone.repository;


import com.project.medicumzone.model.enitity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findAppUserByEmail(String email);
    public AppUser findAppUserByUsername(String username);
}
