package com.conti.web.parking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conti.web.parking.model.ChargingStation;
import com.conti.web.parking.repo.ChargingStationDao;
import com.conti.web.parking.service.ChargingStationService;

@Service("chargingStation")
public class ChargingStationServiceImpl implements ChargingStationService{

	@Autowired 
	ChargingStationDao chargingStationDao;
	
	@Override
	public List<ChargingStation> findAllFreeStations() {
		return chargingStationDao.findAllFreeChargingStations();
	}

	@Override
	public boolean isFree(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnectedTo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getChargingPower(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
