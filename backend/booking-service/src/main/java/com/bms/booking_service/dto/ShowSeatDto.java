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
    private Integer id;
    private Integer showId;
    private BigDecimal price;
    private String state;
    private Integer lockedBy;
    private LocalDateTime lockedAt;
}
