package com.bms.show_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueDto {
    private Integer id;
    private String title;
    private Integer adminId;
    private String city;
    private String address;
}
