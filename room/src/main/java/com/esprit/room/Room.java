package com.esprit.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Room implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6;
	@Id
	@GeneratedValue
	private int id;
	
	private int room_number;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ward_id")
	private Ward ward;
	@JsonIgnore
	@OneToMany(
	        mappedBy = "room",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	private List<Bed> beds = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoom_number() {
		return room_number;
	}
	public void setRoom_number(int room_number) {
		this.room_number = room_number;
	}
	public Ward getWard() {
		return ward;
	}
	public void setWard(Ward ward) {
		this.ward = ward;
	}
	public List<Bed> getBeds() {
		return beds;
	}
	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}
	public Room(int room_number) {
		super();
		this.room_number = room_number;
	}
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
