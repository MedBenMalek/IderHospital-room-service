package com.esprit.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoomRepository extends JpaRepository<Room, Integer> {
	
	@Query("select c from Room c where c.room_number like :number")
	public Page<Room> RoomByNumber(@Param("number") int n, Pageable pageable);
	
	@Query("select c from Room c where c.ward.name like :name")
	public Page<Room> RoomByWard(@Param("name") String n, Pageable pageable);
	
}
