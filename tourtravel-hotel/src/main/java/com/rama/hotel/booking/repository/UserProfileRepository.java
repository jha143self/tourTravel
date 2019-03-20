package com.rama.hotel.booking.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rama.hotel.booking.model.UserProfile;

@Transactional
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

	
    public  UserProfile findByType(String type);

	public Optional<UserProfile> findById(int id); 

}
