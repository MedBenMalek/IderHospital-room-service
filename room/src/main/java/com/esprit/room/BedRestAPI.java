package com.esprit.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/beds")
public class BedRestAPI {
	private String title = "Hello, I'm the condidate Microservice";
	@Autowired
	private BedService bedService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	@PostMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Bed> createBed(@PathVariable(value = "id") int id, @RequestBody Bed Bed){
		return new ResponseEntity<>(bedService.addBed(id, Bed), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Bed> updateBed(@PathVariable(value = "id") int id,@RequestBody Bed Bed){
		return new ResponseEntity<>(bedService.updateBed(id, Bed), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteBed(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(bedService.deleteBed(id), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}/patient/{patient_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<BedHistory> assignPatientBed(@PathVariable(value = "id") int id, @PathVariable(value = "patient_id") int patient_id, @RequestBody BedHistory bedHistory){
		return new ResponseEntity<>(bedService.AssignPatientToBed(id, patient_id, bedHistory), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}/release/{patient_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<BedHistory> releasePatientBed(@PathVariable(value = "id") int id, @PathVariable(value = "patient_id") int patient_id){
		return new ResponseEntity<>(bedService.releasePatientFromBed(id, patient_id), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}/room/{id_room}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Bed> assignBedRoom(@PathVariable(value = "id") int id,@PathVariable(value = "id_room") int id_room){
		return new ResponseEntity<>(bedService.assignBedToRoom(id, id_room), HttpStatus.OK);
	}
}
