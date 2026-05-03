package com.bms.show_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventDto {
    private Integer id;
    private String title;
    private String description;
    private Integer durationMinutes;
    private Integer category;
    private Integer ageRating;
    private LocalDate releaseDate;
}
