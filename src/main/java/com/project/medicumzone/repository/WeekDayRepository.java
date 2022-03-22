package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.WeekDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekDayRepository extends JpaRepository<WeekDay,Long> {
}
