package ru.lubovflek.daysto.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.dto.SaveEventDto;
import ru.lubovflek.daysto.model.entity.EventEntity;
import ru.lubovflek.daysto.model.entity.UserEntity;
import ru.lubovflek.daysto.repository.EventRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper mapper;

    public void saveEvent(EventEntity eventEntity) {
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

    public List<EventDto> makeDtoFromEntity(List<EventEntity> events) {
        return events.stream().map(entity -> mapper.map(entity, EventDto.class)).toList();
    }
}
