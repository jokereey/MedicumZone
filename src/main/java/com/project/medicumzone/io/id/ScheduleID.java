package com.project.medicumzone.io.id;

import com.project.medicumzone.io.enitity.WeekDay;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ScheduleID implements Serializable {


    @Column(name="doctor_id")
    private Long doctorId;

    @Column(name = "clinic_id")
    private Long clinicId;

    @Column(name ="weekday_id")
    private Long weekDayId;
}
