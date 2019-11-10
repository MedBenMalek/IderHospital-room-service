package com.esprit.room;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bed implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7;
    @Id
    @GeneratedValue
    private int id;
    private int bed_number;

    @Enumerated(EnumType.STRING)
    private Status status;

    private int takenBy;

    @JsonIgnore
    @OneToMany(
            mappedBy = "bed",
            cascade = CascadeType.ALL
    )
    private List<BedHistory> bedHistories = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBed_number() {
        return bed_number;
    }

    public void setBed_number(int bed_number) {
        this.bed_number = bed_number;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(int takenBy) {
        this.takenBy = takenBy;
    }

    public Bed(int bed_number) {
        super();
        this.bed_number = bed_number;
    }

    public List<BedHistory> getBedHistories() {
        return bedHistories;
    }

    public void setBedHistories(List<BedHistory> bedHistories) {
        this.bedHistories = bedHistories;
    }

    public Bed() {
        super();
    }


}
