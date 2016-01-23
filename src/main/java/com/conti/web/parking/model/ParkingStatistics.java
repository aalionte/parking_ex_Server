package com.conti.web.parking.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "parking_statistics")
@SuppressWarnings("serial")
public class ParkingStatistics implements Serializable {
	/*
	 * id SERIAL UNIQUE NOT NULL, gate_id integer references gates(id),
	 * parking_place_id integer references parking_place(id), enter_time date,
	 * exit_time date
	 */
	public ParkingStatistics() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonManagedReference
	@JoinColumn(name = "gate_id", insertable = false, updatable = false, nullable = false)
	private Gate gate;

	@ManyToOne(fetch = FetchType.EAGER)
	@JsonManagedReference
	@JoinColumn(name = "parking_place_id", insertable = false, updatable = false, nullable = false)
	private ParkingPlace parkingPlace;

	@Column(name = "enter_time")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime enterTime;

	@Column(name = "exit_time")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime exitTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gate getGate() {
		return gate;
	}

	public void setGate(Gate gate) {
		this.gate = gate;
	}

	public ParkingPlace getParkingPlace() {
		return parkingPlace;
	}

	public void setParkingPlace(ParkingPlace parkingPlace) {
		this.parkingPlace = parkingPlace;
	}

	public DateTime getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(DateTime enterTime) {
		this.enterTime = enterTime;
	}

	public DateTime getExitTime() {
		return exitTime;
	}

	public void setExitTime(DateTime exitTime) {
		this.exitTime = exitTime;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (id == null || obj == null || getClass() != obj.getClass())
			return false;
		ParkingPlace that = (ParkingPlace) obj;
		return id.equals(that.getId());
	}

	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

}
