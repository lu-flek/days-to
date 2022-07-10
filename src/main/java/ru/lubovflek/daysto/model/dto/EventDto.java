package ru.lubovflek.daysto.model.dto;

import com.sun.istack.NotNull;

import java.time.LocalDate;

public record EventDto(@NotNull Long id,
                       String name,
                       LocalDate date) {

}
