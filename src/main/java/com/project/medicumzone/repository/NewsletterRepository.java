package com.project.medicumzone.repository;

import com.project.medicumzone.io.enitity.NewsletterNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterRepository extends JpaRepository<NewsletterNotification,Long> {
}
