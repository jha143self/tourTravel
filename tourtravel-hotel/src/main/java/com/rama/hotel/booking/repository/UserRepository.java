package com.rama.hotel.booking.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rama.hotel.booking.model.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

	
	public Optional<User> findByEmail(String email);

    public Optional<User> findByUsername(String username);

    public void deleteByUsername(String username);

    public void deleteByEmail(String email);

    @Query(value = "SELECT e.user_id FROM APP_USER_USER_PROFILE AS e WHERE e.user_profile_id = :role", nativeQuery = true)
    public List<Integer>  findByRole(@Param("role") int roleId);

	public Optional<User> findById(int id); 
	
	
}
