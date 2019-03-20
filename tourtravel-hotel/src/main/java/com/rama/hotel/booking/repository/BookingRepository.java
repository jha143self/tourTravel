package com.rama.hotel.booking.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rama.hotel.booking.model.Booking;



@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {

	
	 public Booking findByRoomId(int roomId); 

	 public List<Booking> findByUserId(int userId);

	 public void deleteByRoomId(int roomId);

	 public void deleteByUserId(int userId);

	 public List<Booking> findByStatus(String status);

	     @Query(value = "SELECT e.* FROM Booking AS e WHERE e.room_type_id = :roomType", nativeQuery = true)
	 public List<Booking> findByRoomTypeId(@Param("roomType") int roomTypeId);

	public Optional<Booking> findById(int id);

	public void deleteById(int id);

	public Optional<Booking> findById(long id); 
	
	
}
