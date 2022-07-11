package ru.lubovflek.daysto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.dto.SaveEventDto;
import ru.lubovflek.daysto.model.entity.EventEntity;
import ru.lubovflek.daysto.model.entity.UserEntity;
import ru.lubovflek.daysto.repository.EventRepository;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final UserService userService;

    public void saveEvent(SaveEventDto saveEventDto) {
        UserEntity user = userService.getUserById(saveEventDto.userId());
        EventEntity eventEntity = new EventEntity(null, saveEventDto.name(), saveEventDto.date(), user);
        eventRepository.save(eventEntity);
    }

    public void updateEvent(EventDto eventDto) {
        EventEntity eventEntity = eventRepository.findById(eventDto.getId()).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Event with id = %d hasn't been found in db", eventDto.getId()));
        });
        eventEntity.setName(eventDto.getName());
        eventEntity.setDate(eventDto.getDate());

        eventRepository.save(eventEntity);
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }
}
