package ru.lubovflek.daysto.model.dto;

import com.sun.istack.NotNull;

import java.time.OffsetDateTime;

public record EventDto(@NotNull Long id,
                       String name,
                       OffsetDateTime time) {

}
