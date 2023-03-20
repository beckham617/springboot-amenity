package com.springboot_amenity.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot_amenity.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
