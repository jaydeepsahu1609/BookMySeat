package com.bms.show_service.entity;

import com.bms.show_service.constants.EntityConstants;
import jakarta.persistence.Column;
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
@Table(name = EntityConstants.CATALOG_SEAT)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CatalogSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = EntityConstants.CATALOG_ID, nullable = false)
    private Catalog catalog;

    @Column(name = "row_label", nullable = false, length = 10)
    private String rowLabel;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(name = "seat_type", nullable = false)
    private Integer seatType;
}
