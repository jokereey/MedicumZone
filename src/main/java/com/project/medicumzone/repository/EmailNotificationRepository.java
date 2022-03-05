package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.EmailNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotification,Long > {
}
