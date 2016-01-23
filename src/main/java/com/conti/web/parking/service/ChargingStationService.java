package com.conti.web.parking.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.conti.web.parking.model.ChargingStation;

@Component
public interface ChargingStationService {

	public List<ChargingStation> findAllFreeStations();

	public boolean isFree(Long id);

	public boolean isConnectedTo(Long id);

	public int getChargingPower(Long id);
}
