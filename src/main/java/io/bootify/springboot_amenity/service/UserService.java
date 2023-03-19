package io.bootify.springboot_amenity.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.bootify.springboot_amenity.domain.Reservation;
import io.bootify.springboot_amenity.domain.User;
import io.bootify.springboot_amenity.model.ReservationDTO;
import io.bootify.springboot_amenity.model.UserDTO;
import io.bootify.springboot_amenity.repos.ReservationRepository;
import io.bootify.springboot_amenity.repos.UserRepository;
import io.bootify.springboot_amenity.util.NotFoundException;

@Service
public class UserService {


    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> findAll() {
        final List<User> users = userRepository.findAll(Sort.by("id"));
        return users.stream()
                .map((user) -> mapToDTO(user, new UserDTO()))
                .toList();
    }

    public UserDTO get(final Long id) {
        return userRepository.findById(id)
                .map(user -> mapToDTO(user, new UserDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UserDTO userDTO) {
        final User user = new User();
        mapToEntity(userDTO, user);
        return userRepository.save(user).getId();
    }

    public void update(final Long id, final UserDTO userDTO) {
        final User user = userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(userDTO, user);
        userRepository.save(user);
    }

    public void delete(final Long id) {
    	userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(final User user,
            final UserDTO userDTO) {
    	userDTO.setId(user.getId());
    	userDTO.setUserName(user.getUserName());
        return userDTO;
    }

    private User mapToEntity(final UserDTO userDTO,
            final User user) {
        user.setUserName(userDTO.getUserName());
        return user;
    }


}
