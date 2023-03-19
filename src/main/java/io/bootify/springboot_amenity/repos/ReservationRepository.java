package io.bootify.springboot_amenity.repos;

import io.bootify.springboot_amenity.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
