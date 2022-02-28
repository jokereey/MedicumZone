package com.project.medicumzone.io.request;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AppointmentRequest implements Serializable {
    private String clientName;
    private String clientSurname;
    private String clientPhoneNumber;

    private String doctorName;
    private String clinicName;

    private LocalDateTime appointmentDate;

}
