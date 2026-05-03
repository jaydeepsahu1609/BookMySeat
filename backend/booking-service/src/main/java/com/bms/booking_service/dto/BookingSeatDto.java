package com.bms.booking_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingSeatDto {
    private Integer id;
    private BookingDto booking;
    private ShowSeatDto showSeat;
}
