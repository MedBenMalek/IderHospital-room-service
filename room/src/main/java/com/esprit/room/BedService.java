package com.esprit.room;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedService {
	
	@Autowired
	private BedRepository bedRepository;
	@Autowired
	private BedHistoryRepository bedHistoryRepository;
	@Autowired
	private RoomRepository roomRepository;
	
	public Bed addBed(int id, Bed Bed) {
		Room room = roomRepository.findById(id).get();
		Bed.setRoom(room);
		return bedRepository.save(Bed);
	}
	
	public Bed updateBed(int id, Bed newBed) {
		if (bedRepository.findById(id).isPresent()) {
			Bed existingBed = bedRepository.findById(id).get();
			existingBed.setBed_number(newBed.getBed_number());
			return bedRepository.save(existingBed);

		} else {
			return null;
		}
	}
	
	public String deleteBed(int id) {
		if (bedRepository.findById(id).isPresent()) {
			bedRepository.deleteById(id);
			return "Bed deleted";
		} else {
			return "Bed not deleted";
		}
	}
	
	public BedHistory AssignPatientToBed(int id, int patient_id, BedHistory bedHistory) {
		if (bedRepository.findById(id).isPresent()) {
			
			//update bed
			Bed existingBed = bedRepository.findById(id).get();
			existingBed.setTakenBy(patient_id);
			existingBed.setStatus(Status.disabled);
			bedRepository.save(existingBed);
			
			//create history for bed
			bedHistory.setBed(existingBed);
			bedHistory.setDate_start(new Date());
			bedHistory.setPatient_id(patient_id);
			return bedHistoryRepository.save(bedHistory);

		} else {
			return null;
		}
	}
	
	public BedHistory releasePatientFromBed(int id, int patient_id) {
		
		if (bedRepository.findById(id).isPresent()) {
			
			Bed existingBed = bedRepository.findById(id).get();
			List<BedHistory> histories = existingBed.getBedHistories();
			
			for (BedHistory h : histories) {
		        if (h.getPatient_id() == patient_id && h.getDate_end() == null) {
		        	
		        	//reset bed
					existingBed.setTakenBy(0);
					existingBed.setStatus(Status.available);
					bedRepository.save(existingBed);
		        	
					//update history
		        	h.setDate_end(new Date());
		        	return bedHistoryRepository.save(h);
		        }
		    }
			
			//TypedQuery<BedHistory> query = em.createQuery("SELECT h FROM BedHistory h WHERE h.patient_id="+patient_id+"AND h.bed.id ="+id+"AND h.date_end =null", BedHistory.class);
			//BedHistory bedHistory = query.getSingleResult();
			//bedHistory.setDate_end(new Date());
			return null;
		}
		
		return null;
	}
	
	public Bed assignBedToRoom(int id, int id_room) {
		if (roomRepository.findById(id_room).isPresent() && bedRepository.findById(id).isPresent()) {
			Bed existingBed = bedRepository.findById(id).get();
			Room existingRoom = roomRepository.findById(id_room).get();
			existingBed.setRoom(existingRoom);
			return bedRepository.save(existingBed);

		} else {
			return null;
		}
	}

}
