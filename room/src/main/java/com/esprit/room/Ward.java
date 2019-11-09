package com.esprit.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ward implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6;
	@Id
	@GeneratedValue
	private int id;
	private String name;
	@JsonIgnore
	@OneToMany(
	        mappedBy = "ward",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Room> rooms = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Ward(String name) {
		super();
		this.name = name;
	}

	public Ward() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
