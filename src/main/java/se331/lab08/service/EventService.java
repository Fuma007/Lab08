package se331.lab08.service;

import se331.lab08.entity.Event;

import java.util.List;

public interface EventService {
    Integer getEventSize();
    List<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
}