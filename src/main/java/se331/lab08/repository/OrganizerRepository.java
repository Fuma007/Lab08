package se331.lab08.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab08.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}