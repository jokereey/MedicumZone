package com.project.medicumzone.exception;

public class TranslationException extends RuntimeException{

    public TranslationException(String message) {
        super(message +" is not a week day!");
    }
}
