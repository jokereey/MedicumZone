package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.DoctorSchedule;
import com.project.medicumzone.io.id.ScheduleID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<DoctorSchedule, ScheduleID> {
}
