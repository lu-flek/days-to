package ru.lubovflek.daysto.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.dto.SaveEventDto;
import ru.lubovflek.daysto.model.entity.EventEntity;
import ru.lubovflek.daysto.model.entity.UserEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DaysToFacade {

    private final UserService userService;
    private final EventService eventService;

    public void saveEvent(SaveEventDto saveEventDto) {
        UserEntity user = userService.getUserById(saveEventDto.userId());
        EventEntity eventEntity = new EventEntity(null, saveEventDto.name(), saveEventDto.date(), user);
        eventService.saveEvent(eventEntity);
    }

    public List<EventDto> getAllEventsByUserName(String name) {
        UserEntity user = userService.getUserByName(name);
        return eventService.makeDtoFromEntity(user.getEvents());
    }
}
