package com.esprit.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OperatingRoomRepository extends JpaRepository<OperatingRoom, Integer> {
	
	@Query("select c from OperatingRoom c where c.number like :number")
	public Page<OperatingRoom> OperatingRoomByNumber(@Param("number") int n, Pageable pageable);

}
