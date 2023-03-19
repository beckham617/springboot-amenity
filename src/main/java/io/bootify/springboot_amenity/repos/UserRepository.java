package io.bootify.springboot_amenity.repos;

import io.bootify.springboot_amenity.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
