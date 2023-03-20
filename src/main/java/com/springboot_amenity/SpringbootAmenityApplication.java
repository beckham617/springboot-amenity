package com.springboot_amenity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot_amenity.model.AmenityType;
import com.springboot_amenity.model.Reservation;
import com.springboot_amenity.model.User;
import com.springboot_amenity.repos.ReservationRepository;
import com.springboot_amenity.repos.UserRepository;


@SpringBootApplication
public class SpringbootAmenityApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SpringbootAmenityApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository,
                                      ReservationRepository reservationRepository) {
        return (args) -> {
        	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date date = new Date();
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int i=0;
            while(i<10) {
        	User newUser = User.builder()
        			.id(Long.valueOf(i))
        			.userName("test user")
        			.dateCreated(OffsetDateTime.now())
        			.lastUpdated(OffsetDateTime.now())
        			.build();
            User user = userRepository.save(newUser);
            Reservation reservation = Reservation.builder()
            		.id(Long.valueOf(i))
                    .reservationDate(localDate)
                    .startTime(LocalTime.of(12, 00))
                    .endTime(LocalTime.of(13, 00))
                    .user(user)
                    .amenityType(AmenityType.POOL)
        			.dateCreated(OffsetDateTime.now())
        			.lastUpdated(OffsetDateTime.now())
                    .build();

            reservationRepository.save(reservation);
            i++;
            }
		};
	}
}
