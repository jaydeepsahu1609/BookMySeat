package com.bms.show_service.entity;

import com.bms.show_service.constants.EntityConstants;
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

@Entity
@Table(name = EntityConstants.CATALOG)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name = "total_rows", nullable = false)
    private Integer totalRows;

    @Column(name = "total_columns", nullable = false)
    private Integer totalColumns;
}
