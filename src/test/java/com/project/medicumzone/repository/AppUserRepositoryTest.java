package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.AppUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@AutoConfigureDataJpa
@AutoConfigureCache
@Transactional
class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository underTest;
    private static final String USER_EMAIL = "example@gmail.com";
    private static final String USER_USERNAME = "username";


    @Test
    void userShouldExistsByEmail() {
        //given
        underTest.save(createAppUser());
        //when
        boolean exists = underTest.existsByEmail(USER_EMAIL);
        //then
        assertTrue(exists);

    }

    @Test
    void userShouldNotExistsByEmail() {
        //given
        underTest.deleteAll();
        //when
        boolean exists = underTest.existsByEmail(USER_EMAIL);
        //then
        assertFalse(exists);

    }

    @Test
    void shouldFindUserByEmail() {
        //given
        underTest.save(createAppUser());
        //when
        AppUser user = underTest.findAppUserByEmail(USER_EMAIL);
        //then
        assertEquals(USER_EMAIL, user.getEmail());

    }

    @Test
    void shouldFindUserByUsername() {
        //given
        underTest.save(createAppUser());
        //when
        AppUser user = underTest.findAppUserByUsername(USER_USERNAME);
        //then
        assertEquals(USER_USERNAME, user.username());

    }

    private AppUser createAppUser() {
        return AppUser.builder()
                .email(USER_EMAIL)
                .username(USER_USERNAME)
                .build();
    }


}
