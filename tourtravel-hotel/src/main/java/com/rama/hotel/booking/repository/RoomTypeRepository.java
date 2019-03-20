package com.rama.hotel.booking.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rama.hotel.booking.model.RoomType;

@Transactional
public interface RoomTypeRepository extends JpaRepository<RoomType, Long>{

   public RoomType findByType(String type);

public Optional<RoomType> findById(int id);

}
