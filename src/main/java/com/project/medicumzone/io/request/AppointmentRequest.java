package com.project.medicumzone.io.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class AppointmentRequest implements Serializable {
    private Long userId;
    private Long doctorId;
    private Long clinicId;

    private LocalDateTime date;


}
