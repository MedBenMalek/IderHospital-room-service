package com.esprit.room;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BedHistory  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8;
	@Id
	@GeneratedValue
	private int id;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "bed_id")
	private Bed bed;
	
	private int patient_id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_start;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_end;
	
	private String cause;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public Date getDate_start() {
		return date_start;
	}

	public void setDate_start(Date date_start) {
		this.date_start = date_start;
	}

	public Date getDate_end() {
		return date_end;
	}

	public void setDate_end(Date date_end) {
		this.date_end = date_end;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public BedHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	

}
