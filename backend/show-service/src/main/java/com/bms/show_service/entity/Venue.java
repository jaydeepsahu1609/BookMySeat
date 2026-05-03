package com.bms.show_service.entity;

import com.bms.show_service.constants.EntityConstants;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = EntityConstants.VENUE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Venue {
    @Id
    private String id;
    private String title;
    private String adminId;
    private String city;
}
