package com.project.medicumzone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:secrets.properties")
public class TwilioConfig {

    @Value("${twilio.acount-sid}")
    private String apiKey;

    @Value("${twilio.trial-number}")
    private  String trialNumber;

    @Value("${twilio.auth-token}")
    private  String authToken;

    public String getApiKey() {
        return apiKey;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public String getAuthToken() {
        return authToken;
    }
}
