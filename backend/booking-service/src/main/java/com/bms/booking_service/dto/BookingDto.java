package com.bms.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingDto {
    private Integer id;
    private Integer showId;
    private String state;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;
}
