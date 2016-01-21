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

@Entity
@Table(name = "chargin_station")
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
public class ChargingStation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "isFree")
	private boolean isFree;

	@Column(name = "isConnected")
	private boolean isConnected;

	@Column(name = "power") // , default="100")
	private int power;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinTable(name = "parking_place", joinColumns = { @JoinColumn(name = "parking_place_id") }, inverseJoinColumns = {
			@JoinColumn(name = "id") })
	private ParkingPlace parking_place;

}
