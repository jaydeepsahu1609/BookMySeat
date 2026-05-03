package com.bms.show_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDto {
    private String id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private EventDto event;
    private AuditoriumDto auditorium;
}
