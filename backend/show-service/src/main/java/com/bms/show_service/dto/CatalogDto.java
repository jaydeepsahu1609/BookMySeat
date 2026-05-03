package com.bms.show_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogDto {
    private Integer id;
    private String name;
    private Integer totalRows;
    private Integer totalColumns;
}
