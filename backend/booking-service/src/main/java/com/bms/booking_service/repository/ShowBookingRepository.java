package com.bms.booking_service.repository;

import com.bms.booking_service.entity.ShowBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowBookingRepository extends JpaRepository<ShowBooking, String> {
}
