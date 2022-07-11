package ru.lubovflek.daysto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;
}
