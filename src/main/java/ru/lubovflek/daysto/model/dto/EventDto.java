package ru.lubovflek.daysto.model.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventDto {

    @NotNull
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private LocalDate date;


}
