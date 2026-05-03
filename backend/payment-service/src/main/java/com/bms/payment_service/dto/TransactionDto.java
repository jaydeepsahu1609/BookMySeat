package com.bms.payment_service.dto;

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
public class TransactionDto {
    private String id;
    private String state;
    private BigDecimal amount;
    private String bookingId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
