package com.springboot_amenity.service;

import org.springframework.web.server.ResponseStatusException;

import com.springboot_amenity.model.Reservation;
import com.springboot_amenity.repos.ReservationRepository;
import com.springboot_amenity.repos.UserRepository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

	private final ReservationRepository reservationRepository;

	public ReservationService(final ReservationRepository reservationRepository, final UserRepository userRepository) {
		this.reservationRepository = reservationRepository;
	}

	public List<Reservation> findAll() {
		return reservationRepository.findAll(Sort.by("id"));
	}

	public Reservation get(final Long id) {
		return reservationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public Long create(final Reservation reservation) {
		return reservationRepository.save(reservation).getId();
	}

	public void update(final Long id, final Reservation reservation) {
		reservationRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		reservationRepository.save(reservation);
	}

	public void delete(final Long id) {
		reservationRepository.deleteById(id);
	}

}
