package ru.lubovflek.daysto.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.lubovflek.daysto.model.dto.EventDto;
import ru.lubovflek.daysto.model.entity.EventEntity;
import ru.lubovflek.daysto.model.entity.UserEntity;
import ru.lubovflek.daysto.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ModelMapper mapper;

    public UserEntity getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
            throw new IllegalArgumentException(String.format("Пользователь с id = %d не найден в бд", userId));
        });
    }

    public List<EventDto> getEventsByUserId(Long userId) {
        UserEntity user = getUserById(userId);
        List<EventEntity> events = user.getEvents();
        return events.stream().map(entity -> mapper.map(entity, EventDto.class)).toList();
    }
}
