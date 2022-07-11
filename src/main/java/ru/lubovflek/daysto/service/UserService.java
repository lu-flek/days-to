package ru.lubovflek.daysto.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.lubovflek.daysto.model.dto.AddUserDto;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.dto.UserDto;
import ru.lubovflek.daysto.model.entity.EventEntity;
import ru.lubovflek.daysto.model.entity.UserEntity;
import ru.lubovflek.daysto.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("User with id = %d hasn't been found in db", userId));
        });
    }

    public List<EventDto> getEventsByUserId(Long userId) {
        UserEntity user = getUserById(userId);
        List<EventEntity> events = user.getEvents();
        return events.stream().map(entity -> mapper.map(entity, EventDto.class)).toList();
    }

    @SuppressWarnings("unchecked")
    public void addUser(AddUserDto addUserDto) {
        UserEntity user = new UserEntity(null, addUserDto.name(), addUserDto.password(), Collections.EMPTY_LIST);
        userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.stream().map(entity -> mapper.map(entity, UserDto.class)).toList();
    }
}
