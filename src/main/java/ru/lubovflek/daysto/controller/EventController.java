package ru.lubovflek.daysto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.dto.SaveEventDto;
import ru.lubovflek.daysto.service.DaysToFacade;
import ru.lubovflek.daysto.service.EventService;
import ru.lubovflek.daysto.service.UserService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    private final DaysToFacade facade;
    private final EventService eventService;

    @GetMapping("/all")
    public List<EventDto> getAllUserEvents(Principal principal) {
        return facade.getAllEventsByUserName(principal.getName());
    }

    @PostMapping("/add")
    public void addEvent(@Valid @RequestBody SaveEventDto saveEventDto) {
        facade.saveEvent(saveEventDto);
    }

    @PostMapping("/update")
    public void updateEvent(@Valid @RequestBody EventDto eventDto) {
        eventService.updateEvent(eventDto);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable(name = "id") Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
