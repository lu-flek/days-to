package ru.lubovflek.daysto.model.dto;

import javax.validation.constraints.NotNull;

public record AddUserDto(@NotNull String name,
                         @NotNull String password) {
}
