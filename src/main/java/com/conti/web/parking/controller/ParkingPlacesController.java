package com.conti.web.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.conti.web.parking.service.ParkingPlaceService;

@RestController
public class ParkingPlacesController {

	@Autowired
	ParkingPlaceService service;

	@RequestMapping(value = "/parking/getFreePlaces", method = RequestMethod.GET)
	public long parkingPlaceAction() {
		return service.countFreeParkingPlaces();
	}
}
