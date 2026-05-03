package com.bms.show_service.repository;

import com.bms.show_service.entity.CatalogSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogSeatRepository extends JpaRepository<CatalogSeat, Integer> {
}
