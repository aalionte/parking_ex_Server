package com.conti.web.parking.service.impl;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.conti.web.parking.utils.Direction;
import com.conti.web.parking.model.ParkingPlace;
import com.conti.web.parking.model.ParkingStatistics;
import com.conti.web.parking.repo.GateDao;
import com.conti.web.parking.repo.ParkingPlaceDao;
import com.conti.web.parking.repo.ParkingStatisticsDao;
import com.conti.web.parking.service.ParkingStatisticsService;

@Service
public class ParkingStatisticsServiceImpl implements ParkingStatisticsService {

	@Autowired
	ParkingStatisticsDao parkingStatisticsDao;

	@Autowired
	GateDao gateDao;

	@Autowired
	ParkingPlaceDao parkingPlaceDao;

	@Override
	public void parkingPlaceAction(Long gateId, Long parkingPlaceId, String direction) {
		final Direction directionE = Direction.valueOf(direction);
		final DateTime now = new DateTime();
		final boolean isFree = (directionE.equals(Direction.IN)) ? false : true;

		ParkingPlace parkingPlace = parkingPlaceDao.findOne(parkingPlaceId);
		ParkingStatistics parkingDetails = new ParkingStatistics();
		parkingDetails.setGate(gateDao.findOne(gateId));
		parkingDetails.setParkingPlace(parkingPlace);

		if (directionE.equals(Direction.IN)) {
			// enter
			parkingDetails.setEnterTime(now);
			parkingStatisticsDao.save(parkingDetails);
		} else {
			// exit
			// parkingDetails.setExitTime(now);
			parkingStatisticsDao.exit(parkingPlaceId, gateId, now);
		}

		parkingPlace.setFree(isFree);
		parkingPlaceDao.save(parkingPlace);

	}

}
