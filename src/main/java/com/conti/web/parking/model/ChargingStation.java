package com.conti.web.parking.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "charging_station")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class ChargingStation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "is_connected")
	private boolean isConnected;

	@Column(name = "power")
	private int power;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parking_place_id")
	@JsonManagedReference
	private ParkingPlace parkingPlace;

	protected ChargingStation() {

	}

	public ChargingStation(Long id, int power, boolean isConnected) {
		this.id = id;
		this.power = power;
		this.isConnected = isConnected;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public ParkingPlace getParking_place() {
		return parkingPlace;
	}

	public void setParking_place(ParkingPlace parking_place) {
		this.parkingPlace = parking_place;
	}

}
