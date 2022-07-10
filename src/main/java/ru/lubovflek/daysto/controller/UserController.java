package ru.lubovflek.daysto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{user-id}")
    public List<EventDto> getEventsByUserId(@PathVariable(name = "user-id") Long userId) {
        return userService.getEventsByUserId(userId);
    }
}
