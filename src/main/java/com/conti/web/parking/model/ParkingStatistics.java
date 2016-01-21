package com.conti.web.parking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name = "parking_statistics")
@SuppressWarnings("serial")
public class ParkingStatistics implements Serializable {
	/*
	 * id SERIAL UNIQUE NOT NULL, gate_id integer references gates(id),
	 * parking_place_id integer references parking_place(id), enter_time date,
	 * exit_time date
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//
	@ManyToOne
	private Gate gate;

	@ManyToOne
	private ParkingPlace parkingPlace;

	@Column(name = "enter_time")
	private DateTime enterTime;

	@Column(name = "exit_time")
	private DateTime exitTime;
}
