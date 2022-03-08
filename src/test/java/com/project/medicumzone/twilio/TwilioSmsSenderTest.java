package com.project.medicumzone.twilio;

import com.project.medicumzone.config.TwilioConfig;
import com.project.medicumzone.utils.PhoneNumberValidator;
import com.twilio.rest.api.v2010.account.MessageCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(
        properties = "application-it.properties"
)
class TwilioSmsSenderTest {

    private TwilioSmsSender underTest;
    @Autowired
    private TwilioConfig twilioConfig;
    private PhoneNumberValidator phoneNumberValidator;
    private MessageCreator messageCreator;

    @BeforeEach
    void setUp() {
        phoneNumberValidator = new PhoneNumberValidator();
        underTest = new TwilioSmsSender(twilioConfig,phoneNumberValidator);
    }

    @Test
    void shouldNotSendSms() {
        var request = getIncorrectRequest();
        boolean isSent = underTest.sendSms(request);
        assertEquals(isSent,false);
    }

    @Test
    void shouldSendSmsAndInvokeTwilioApi() {
        underTest.setEnabled(true);
        var request  =  getCorrectRequest();
        boolean isSent = underTest.sendSms(request);
        assertEquals(isSent,true);
    }

    @Test
    void shouldSendSmsWithoutInvokingTwilioApi() {
        var request  =  getCorrectRequest();
        boolean isSent = underTest.sendSms(request);
        assertEquals(isSent,true);
    }



    private SmsRequest getIncorrectRequest(){
          return new  SmsRequest("+48123243","Hello world");
    }
    private SmsRequest getCorrectRequest(){
        return new SmsRequest("+48124688014","hello world");
    }
}
