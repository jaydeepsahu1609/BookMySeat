package com.bms.show_service.entity;

import com.bms.show_service.constants.EntityConstants;
import jakarta.persistence.Entity;
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
    private String id;
    private Integer capacity;
    
    @ManyToOne
    @JoinColumn(name = EntityConstants.VENUE_ID, nullable = false)
    private Venue venue;
}
