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
@RequestMapping(value = "/api/operating-rooms")
public class OperatingRoomRestAPI {
	private String title = "Hello, I'm the condidate Microservice";
	@Autowired
	private OperatingRoomService operatingRoomService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<OperatingRoom> createOperatingRoom(@RequestBody OperatingRoom OperatingRoom){
		return new ResponseEntity<>(operatingRoomService.addOperatingRoom(OperatingRoom), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OperatingRoom> updateOperatingRoom(@PathVariable(value = "id") int id,@RequestBody OperatingRoom OperatingRoom){
		return new ResponseEntity<>(operatingRoomService.updateOperatingRoom(id, OperatingRoom), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteOperatingRoom(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(operatingRoomService.deleteOperatingRoom(id), HttpStatus.OK);
	}
}
