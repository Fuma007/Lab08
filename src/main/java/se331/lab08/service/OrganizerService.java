package se331.lab08.service;

import se331.lab08.entity.Organizer;

import java.util.List;

public interface OrganizerService {
    Integer getOrganizerSize();
    List<Organizer> getOrganizers(Integer pageSize, Integer page);
    Organizer getOrganizer(Long id);
}