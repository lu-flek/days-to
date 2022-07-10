package ru.lubovflek.daysto.model.dto;

import com.sun.istack.NotNull;

import java.time.OffsetDateTime;

public record SaveEventDto(@NotNull String name,
                           @NotNull OffsetDateTime dateTime,
                           @NotNull Long userId) {

}
