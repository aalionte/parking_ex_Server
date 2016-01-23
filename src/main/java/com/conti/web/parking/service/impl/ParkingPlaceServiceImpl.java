package com.conti.web.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conti.web.parking.repo.ParkingPlaceDao;
import com.conti.web.parking.service.ParkingPlaceService;

@Service
public class ParkingPlaceServiceImpl implements ParkingPlaceService {

	@Autowired
	ParkingPlaceDao parkingPlaceDao;

	@Override
	public long countFreeParkingPlaces() {
		return parkingPlaceDao.getAllFreeSpots();
	}

	@Override
	public long getTotal() {
		return parkingPlaceDao.count();
	}

}
