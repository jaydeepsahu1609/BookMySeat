package com.bms.show_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogSeatDto {
    private Integer id;
    private CatalogDto catalog;
    private String rowLabel;
    private Integer seatNumber;
    private Integer seatType;
}
