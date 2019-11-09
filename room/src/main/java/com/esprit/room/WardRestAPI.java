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
@RequestMapping(value = "/api/wards")
public class WardRestAPI {
	private String title = "Hello, I'm the condidate Microservice";
	@Autowired
	private WardService wardService;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Ward> createWard(@RequestBody Ward Ward){
		return new ResponseEntity<>(wardService.addWard(Ward), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Ward> updateWard(@PathVariable(value = "id") int id,@RequestBody Ward Ward){
		return new ResponseEntity<>(wardService.updateWard(id, Ward), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteWard(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(wardService.deleteWard(id), HttpStatus.OK);
	}
}
