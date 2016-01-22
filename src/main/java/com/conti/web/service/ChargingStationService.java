package com.conti.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.conti.web.parking.model.ChargingStation;

public interface ChargingStationService {

	public List<ChargingStation> findAllFreeStations();

	public boolean isFree(Long id);

	public boolean isConnectedTo(Long id);

	public int getChargingPower(Long id);
}
