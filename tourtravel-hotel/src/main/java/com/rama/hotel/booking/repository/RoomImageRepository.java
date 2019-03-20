package com.rama.hotel.booking.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rama.hotel.booking.model.RoomImages;

@Transactional
public interface RoomImageRepository extends JpaRepository<RoomImages, Long>{

	
	   @Query(value = "SELECT e.* FROM ROOM_IMAGE AS e WHERE e.room = :room", nativeQuery = true)
	    public List<RoomImages> findByRoomId(@Param("room") int room );

	public Optional<RoomImages> findById(int id);

	public void deleteById(int id);
}
