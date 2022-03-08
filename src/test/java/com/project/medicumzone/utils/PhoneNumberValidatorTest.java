package com.project.medicumzone.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberValidatorTest {

    private PhoneNumberValidator underTest;
    private static final String VALID_PHONE_NUMBER = "+48123456789";
    private static final String INVALID_PREFIX_PHONE_NUMBER = "+45456982345";
    private static final String INVALID_LENGTH_PHONE_NUMBER_ = "+4812345678";

    @BeforeEach
    void setUp() {
        underTest = new PhoneNumberValidator();
    }

    @Test
    void shouldValidatePhoneNumber() {
        boolean isValid = underTest.test(VALID_PHONE_NUMBER);
        Assertions.assertTrue(isValid);
    }
    @Test
    @DisplayName("Should not validate phone number when length is invalid ")
    void shouldNotValidate() {
        boolean isValid = underTest.test(INVALID_LENGTH_PHONE_NUMBER_);
        Assertions.assertFalse(isValid);
    }
    @Test
    @DisplayName("Should not validate phone number when prefix is incorrect")
    void shouldNotValidate2() {
        boolean isValid = underTest.test(INVALID_PREFIX_PHONE_NUMBER);
        Assertions.assertFalse(isValid);
    }
}