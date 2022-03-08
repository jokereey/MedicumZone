package com.project.medicumzone.twilio;

import com.project.medicumzone.config.TwilioConfig;
import com.project.medicumzone.utils.PhoneNumberValidator;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service("twilio")
@Slf4j
@Getter
public class TwilioSmsSender implements SmsSender{

    private final TwilioConfig twilioConfiguration;
    private final PhoneNumberValidator phoneNumberValidator;

    @Value("${twilio.sender.enabled}")
    private boolean isEnabled;
    private boolean isSent = false;

    public TwilioSmsSender(TwilioConfig twilioConfiguration, PhoneNumberValidator phoneNumberValidator) {
        this.twilioConfiguration = twilioConfiguration;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    @Override
    public boolean sendSms(SmsRequest smsRequest) {
        if(phoneNumberValidator.test(smsRequest.getPhoneNumber())) {
//            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber to = new PhoneNumber(twilioConfiguration.getTwilioAvailableNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getMyTwilioNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,
                    from,
                    message
            );
            if(isEnabled){
                creator.create();
            }
            log.info("Message has been sent successfully. Twilio is disabled");
            isSent = true;
            return isSent;
        }
        log.error("Phone number is invalid.");
        return isSent;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
