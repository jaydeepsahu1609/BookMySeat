package com.bms.booking_service.entity;

import com.bms.booking_service.constants.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private String id;

    @Column(name = EntityConstants.COL_AUDITORIUM_ID, nullable = false)
    private String auditoriumId;

    @Column(name = EntityConstants.COL_SHOW_ID, nullable = false)
    private String showId;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String state;

    @Column(name = EntityConstants.COL_LOCKED_BY)
    private String lockedBy;

    @Column(name = EntityConstants.COL_LOCKED_AT)
    private LocalDateTime lockedAt;
}
