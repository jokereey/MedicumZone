package com.project.medicumzone.io.enitity;

import com.project.medicumzone.io.id.ScheduleID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@NoArgsConstructor

@Getter
@Setter
public class DoctorSchedule implements Serializable {

    @EmbeddedId
    private ScheduleID scheduleID;

    @ManyToOne
    @MapsId("doctorId")
    @JoinColumn(name= "doctor_id", nullable = false,foreignKey = @ForeignKey(name="schedule_doctor_id_fk"))
    private Doctor doctor;

    @ManyToOne
    @MapsId("weekDayId")
    @JoinColumn(name = "weekday_id", nullable = false,foreignKey = @ForeignKey(name="schedule_weekday_id_fk"))
    private WeekDay weekDay;

    @ManyToOne
    @MapsId("clinicId")
    @JoinColumn(name = "clinic_id", nullable = false,foreignKey = @ForeignKey(name="schedule_clinic_id_fk"))
    private Clinic clinic;

    private Integer fromHour;

    private Integer endHour;



    public DoctorSchedule(Doctor doctor, WeekDay weekDay, Clinic clinic, Integer fromHour, Integer endHour) {
        this.doctor = doctor;
        this.weekDay = weekDay;
        this.clinic = clinic;
        this.fromHour = fromHour;
        this.endHour = endHour;

        this.scheduleID = new ScheduleID(doctor.getId(),clinic.getClinicId(),weekDay.getId());
    }
}
