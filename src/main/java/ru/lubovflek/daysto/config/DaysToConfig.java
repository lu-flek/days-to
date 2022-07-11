package ru.lubovflek.daysto.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaysToConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
