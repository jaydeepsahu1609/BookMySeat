package com.bms.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeatDto {
    private String id;
    private String auditoriumId;
    private String showId;
    private BigDecimal price;
    private String state;
    private String lockedBy;
    private LocalDateTime lockedAt;
}
