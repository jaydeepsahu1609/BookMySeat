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

import java.time.LocalDateTime;

@Entity
@Table(name = EntityConstants.SHOW)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Show {
    @Id
    private String id;
    
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    @ManyToOne
    @JoinColumn(name = EntityConstants.EVENT_ID, nullable = false)
    private Event event;
    
    @ManyToOne
    @JoinColumn(name = EntityConstants.AUDITORIUM_ID, nullable = false)
    private Auditorium auditorium;
}
