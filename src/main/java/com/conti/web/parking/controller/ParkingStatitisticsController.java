package com.conti.web.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.conti.web.parking.service.ParkingStatisticsService;

@RestController
@RequestMapping("/parking")
public class ParkingStatitisticsController {

	@Autowired
	ParkingStatisticsService service;

	@RequestMapping(value = "/action", method = RequestMethod.POST, consumes = "application/json", headers = {
			"Content-Type=application/json" })
	public void parkingPlaceAction(@RequestParam("gateId") Long gateId,
			@RequestParam("parkingPlaceId") Long parkingPlaceId, @RequestParam("direction") String direction) {
		service.parkingPlaceAction(gateId, parkingPlaceId, direction);
	}
}
