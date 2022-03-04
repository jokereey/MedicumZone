package com.project.medicumzone.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    private final SmsSender smsSender;

    @Autowired
    public TwilioService(@Qualifier("twilio") SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public boolean sendSms(SmsRequest smsRequest){
        return smsSender.sendSms(smsRequest);
    }
}
