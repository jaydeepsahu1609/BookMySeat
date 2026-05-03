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
public class BookingDto {
    private Integer id;
    private Integer showId;
    private BigDecimal total;
    private String state;
    private LocalDateTime time;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
