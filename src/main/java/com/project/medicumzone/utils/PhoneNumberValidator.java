package com.project.medicumzone.utils;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PhoneNumberValidator implements Predicate<String> {

    @Override
    public boolean test(String phoneNumber) {
        if(phoneNumber.startsWith("+48") && phoneNumber.length()==12){
            return true;
        }
        return false;
    }
}
