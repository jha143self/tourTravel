package com.rama.hotel.booking.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.rama.hotel.booking.model.Room;

@Transactional
public interface RoomRepository extends JpaRepository<Room, Long>  {

	public Optional<Room> findByName(String name); 

	   @Query(value = "SELECT m. * from Room AS m WHERE m.type = :typeId AND m.status = :status", nativeQuery = true)
    public List<Room> findByTypeIdAndStatus(int typeId,String status); 

    public List<Room> findByStatus(String status);

    public void deleteByName(String name);

    @Query(value = "SELECT m.* from Room AS m JOIN (SELECT DISTINCT d.* FROM Room AS d LEFT OUTER JOIN Booking AS c ON c.room_id = d.id WHERE (c.room_id IS NULL) ORDER BY d.name) AS t ON m.id = t.id WHERE m.status LIKE :check", nativeQuery = true)
    public  List<Room> findFreeRooms(@Param("check") String check);

    @Query(value = "SELECT m.* from Room AS m JOIN (SELECT DISTINCT d.* FROM Room AS d LEFT OUTER JOIN Booking AS c ON c.room_id = d.id WHERE (c.room_id IS NULL) ORDER BY d.name) AS t ON m.id = t.id WHERE m.status LIKE :check and m.price >= :minimum and m.price <= :maximum", nativeQuery = true)
    public List<Room>  findFreeRooms(@Param("minimum") int min, @Param("maximum") int max, @Param("check") String check);

    @Query(value = "SELECT m.* from Room AS m JOIN (SELECT DISTINCT d.* FROM Room AS d LEFT OUTER JOIN Booking AS c ON c.room_id = d.id WHERE (c.room_id IS NULL) ORDER BY d.name) AS t ON m.id = t.id WHERE m.status LIKE :check and m.price >= :minimum and m.price <= :maximum and m.type = :type", nativeQuery = true)
    public List<Room>  findFreeRooms(@Param("minimum") int min, @Param("maximum") int max, @Param("type") int type, @Param("check") String check); 

    @Query(value = "SELECT m.* FROM Room AS m JOIN (SELECT e.* FROM Room AS e WHERE e.name LIKE :name) AS t ON m.id = t.id WHERE m.status LIKE :verify", nativeQuery = true)
    public List<Room> findByName(@Param("name") String name, @Param("verify") String verify);

	public Optional<Room> findById(int id);

	public void deleteById(int id);

	
	
	
}
