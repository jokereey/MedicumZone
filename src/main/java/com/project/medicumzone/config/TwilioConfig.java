package com.project.medicumzone.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.vault.annotation.VaultPropertySource;

@Configuration
@Setter
@Getter
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

    public TwilioConfig() {
    }
}
