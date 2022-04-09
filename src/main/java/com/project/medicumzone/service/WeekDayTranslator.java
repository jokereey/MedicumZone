package com.project.medicumzone.service;

import com.project.medicumzone.exception.ApiRequestException;
import com.project.medicumzone.exception.TranslationException;
import com.project.medicumzone.service.contract.Translator;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionalException;

@Service("WeekDay")
public class WeekDayTranslator implements Translator {
    @Override
    public String translate(String weekDay) {
        return switch (weekDay.toLowerCase()) {
            case "monday" -> "Poniedziałek";
            case "tuesday" -> "Wtorek";
            case "wednesday" -> "Środa";
            case "thursday" -> "Czwartek";
            case "friday" -> "Piątek";
            case "saturday" -> "Sobota";
            case "sunday" -> "Niedziela";
            default -> throw new TranslationException(weekDay);
        };

    }
}
