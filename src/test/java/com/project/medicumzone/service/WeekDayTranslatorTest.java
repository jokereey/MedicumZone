package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.exception.TranslationException;
import com.project.medicumzone.service.contract.Translator;
import io.swagger.models.auth.In;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeekDayTranslatorTest {

    Translator underTest;
    private static  final String MONDAY = "MONDAY";
    private static  final String TUESDAY = "TUESDAY";
    private static  final String WEDNESDAY = "WEDNESDAY";
    private static  final String THURSDAY = "THURSDAY";
    private static  final String FRIDAY = "FRIDAY";
    private static  final String SATURDAY = "SATURDAY";
    private static  final String SUNDAY = "SUNDAY";
    private static  final String INVALID_WORD = "INVALID_WORD";

    @BeforeEach
    void setUp() {
        underTest = new WeekDayTranslator();
    }

    @Test
    void itShouldTranslateMonday() {
        //Given
        //When
        var result = underTest.translate(MONDAY);
        //Then
        assertEquals(result,"Poniedziałek");

    }
    @Test
    void itShouldTranslateTuesday() {
        //Given
        //When
        var result = underTest.translate(TUESDAY);
        //Then
        assertEquals(result,"Wtorek");

    }
    @Test
    void itShouldTranslateWednesday() {
        //Given
        //When
        var result = underTest.translate(WEDNESDAY);
        //Then
        assertEquals(result,"Środa");

    }
    @Test
    void itShouldTranslateThursday() {
        //Given
        //When
        var result = underTest.translate(THURSDAY);
        //Then
        assertEquals(result,"Czwartek");

    }
    @Test
    void itShouldTranslateFriday() {
        //Given
        //When
        var result = underTest.translate(FRIDAY);
        //Then
        assertEquals(result,"Piątek");

    }
    @Test
    void itShouldTranslateSaturday() {
        //Given
        //When
        var result = underTest.translate(SATURDAY);
        //Then
        assertEquals(result,"Sobota");

    }
    @Test
    void itShouldTranslateSunday() {
        //Given
        //When
        var result = underTest.translate(SUNDAY);
        //Then
        assertEquals(result,"Niedziela");

    }

    @Test
    void itShouldThrow() {
        //Given
        //When

        Assertions.assertThatThrownBy(() ->underTest.translate(INVALID_WORD))
                .isInstanceOf(TranslationException.class)
                .hasMessageContaining((INVALID_WORD +" is not a week day!"));

    }
}
