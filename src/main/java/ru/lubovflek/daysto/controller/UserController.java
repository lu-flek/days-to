package ru.lubovflek.daysto.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lubovflek.daysto.model.dto.AddUserDto;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.dto.UserDto;
import ru.lubovflek.daysto.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public List<EventDto> getEventsByUserId(@PathVariable(name = "id") Long userId) {
        return userService.getEventsByUserId(userId);
    }

    @PostMapping("/add")
    public void addUser(@Valid AddUserDto addUserDto) {
        userService.addUser(addUserDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
