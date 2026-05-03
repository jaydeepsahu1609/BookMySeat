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
@Table(name = EntityConstants.AUDITORIUM)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "catalog_id", nullable = false)
    private Integer catalogId;
    
    @ManyToOne
    @JoinColumn(name = EntityConstants.VENUE_ID, nullable = false)
    private Venue venue;
}
