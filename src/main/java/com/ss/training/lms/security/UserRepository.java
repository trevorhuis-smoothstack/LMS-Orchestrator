package com.ss.training.lms.security;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Justin O'Brien
 */
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
