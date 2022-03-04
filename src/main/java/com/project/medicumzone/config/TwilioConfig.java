package com.project.medicumzone.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.annotation.VaultPropertySource;

@Configuration
@VaultPropertySource(value = "secret/application",
        renewal = VaultPropertySource.Renewal.RENEW)
public class TwilioConfig {

    @Value("${twilio_account_sid}")
    private String accountSid;

    @Value("${twilio_available_number}")
    private String twilioAvailableNumber;

    @Value("${my_twilio_number}")
    private String myTwilioNumber;

    @Value("${twilio_auth_token}")
    private String authToken;


    public String getAccountSid() {
        return accountSid;
    }

    public String getTwilioAvailableNumber() {
        return twilioAvailableNumber;
    }

    public String getMyTwilioNumber() {
        return myTwilioNumber;
    }

    public String getAuthToken() {
        return authToken;
    }

    public TwilioConfig() {
    }
}
