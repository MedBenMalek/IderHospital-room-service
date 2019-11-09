package com.esprit.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface BedHistoryRepository extends JpaRepository<BedHistory, Integer> {
	
	@Query("select c from BedHistory c where c.bed.bed_number like :number")
	public Page<BedHistory> HistoryBedByNumber(@Param("number") int n, Pageable pageable);
	
	@Query("select c from BedHistory c where c.patient_id like :id")
	public Page<BedHistory> HistoryPatient(@Param("id") int n, Pageable pageable);

}
