package com.bms.booking_service.entity;

import com.bms.booking_service.constants.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = EntityConstants.TABLE_SHOW_SEAT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = EntityConstants.COL_SHOW_ID, nullable = false)
    private Integer showId;

    @Column(name = "catalog_seat_id", nullable = false)
    private Integer catalogSeatId;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private String state;

    @Column(name = EntityConstants.COL_LOCKED_BY)
    private Integer lockedBy;

    @Column(name = EntityConstants.COL_LOCKED_AT)
    private LocalDateTime lockedAt;

    @Column(name = "lock_expires_at")
    private LocalDateTime lockExpiresAt;
}
