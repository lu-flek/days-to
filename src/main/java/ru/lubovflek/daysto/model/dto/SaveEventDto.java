package ru.lubovflek.daysto.model.dto;

import com.sun.istack.NotNull;

import java.time.LocalDate;

public record SaveEventDto(@NotNull String name,
                           @NotNull LocalDate date,
                           @NotNull Long userId) {

}
