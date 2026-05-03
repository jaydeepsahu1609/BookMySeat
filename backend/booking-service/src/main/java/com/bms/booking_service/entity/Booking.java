package com.bms.booking_service.entity;

import com.bms.booking_service.constants.EntityConstants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = EntityConstants.TABLE_BOOKING)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = EntityConstants.COL_SHOW_ID, nullable = false)
    private Integer showId;

    @Column(nullable = false)
    private String state;

    @Column(name = EntityConstants.COL_USER_ID, nullable = false)
    private Integer userId;

    @Column(name = EntityConstants.COL_CREATED_AT, nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = EntityConstants.COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "expires_at")
    private LocalDateTime expiresAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
