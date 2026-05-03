package com.bms.booking_service.entity;

import com.bms.booking_service.constants.EntityConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = EntityConstants.TABLE_SHOW_BOOKING)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = EntityConstants.COL_BOOKING_ID, nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = EntityConstants.COL_SHOW_SEAT_ID, nullable = false)
    private ShowSeat showSeat;
}
