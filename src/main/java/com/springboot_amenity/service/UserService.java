package com.springboot_amenity.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.springboot_amenity.model.User;
import com.springboot_amenity.repos.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		return userRepository.findAll(Sort.by("id"));
	}

	public User get(final Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	public User getUserByUsername(String username) {
        return userRepository.findUserByUserName(username);
    }
	
	public Long create(final User user) {
		return userRepository.save(user).getId();
	}

	public void update(final Long id, final User user) {
		userRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		userRepository.save(user);
	}

	public void delete(final Long id) {
		userRepository.deleteById(id);
	}

}
