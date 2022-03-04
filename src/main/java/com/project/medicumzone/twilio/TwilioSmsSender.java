package com.project.medicumzone.twilio;

import com.project.medicumzone.config.TwilioConfig;
import com.project.medicumzone.utils.PhoneNumberValidator;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;


@Service("twilio")
public class TwilioSmsSender implements SmsSender{

    private final TwilioConfig twilioConfiguration;
    private final PhoneNumberValidator phoneNumberValidator;

    public TwilioSmsSender(TwilioConfig twilioConfiguration, PhoneNumberValidator phoneNumberValidator) {
        this.twilioConfiguration = twilioConfiguration;
        this.phoneNumberValidator = phoneNumberValidator;
    }

    @Override
    public boolean sendSms(SmsRequest smsRequest) {
        if(phoneNumberValidator.test(smsRequest.getPhoneNumber())) {
            PhoneNumber to = new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTwilioAvailableNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(
                    to,
                    from,
                    message
            );
            creator.create();
            System.out.println("true");
            return true;
        }
        System.out.println("FALSE");
        return false;
    }
}
