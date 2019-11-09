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
@RequestMapping(value = "/api/rooms")
public class RoomRestAPI {
	private String title = "Hello, I'm the condidate Microservice";
	@Autowired
	private RoomService roomService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Room> createRoom(@RequestBody Room Room){
		return new ResponseEntity<>(roomService.addRoom(Room), HttpStatus.OK);
	}
	
	@PostMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Room> createRoomByWard(@PathVariable(value = "id") int id,@RequestBody Room Room){
		return new ResponseEntity<>(roomService.addRoomByWard(id, Room), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") int id,@RequestBody Room Room){
		return new ResponseEntity<>(roomService.updateRoom(id, Room), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteRoom(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(roomService.deleteRoom(id), HttpStatus.OK);
	}
}
