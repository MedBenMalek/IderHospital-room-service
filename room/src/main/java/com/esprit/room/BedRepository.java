package com.esprit.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BedRepository extends JpaRepository<Bed, Integer> {
	
	@Query("select c from Bed c where c.status like :bed")
	public Page<Bed> BedAvailability(@Param("bed") int n, Pageable pageable);
	
	@Query("select c from Bed c where c.status = 'available' and c.room.room_number like :number")
	public Page<Bed> BedAvailabilityByRoom(@Param("number") int n, Pageable pageable);
	
	@Query("select c from Bed c where c.status = 'available' and c.room.ward.name like :name")
	public Page<Bed> BedAvailabilityByWard(@Param("name") String n, Pageable pageable);
	
	@Query("select c from Bed c where c.bed_number like :number")
	public Page<Bed> BedByNumber(@Param("number") int n, Pageable pageable);
	
	@Query("select c from Bed c where c.room.room_number like :number")
	public Page<Bed> BedByRoomNumber(@Param("number") int n, Pageable pageable);
	
	@Query("select c from Bed c where c.room.ward.name like :name")
	public Page<Bed> BedByWard(@Param("name") String n, Pageable pageable);
	
	@Query("select c from Bed c where c.takenBy like :id")
	public Page<Bed> BedByPatientId(@Param("id") int n, Pageable pageable);

}
