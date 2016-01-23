package com.conti.web.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conti.web.parking.model.ChargingStation;
import com.conti.web.parking.service.ChargingStationService;

@Controller
@RequestMapping(value = "/chargingStations")
public class ChargingStationController {

	@Autowired
	ChargingStationService chargingStationService;

	@RequestMapping(value = "/free-charging-station", method = RequestMethod.GET, produces = "application/json", headers = {
			"content-type=application/json" })
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody List<ChargingStation> getAllFreeChargingStations() {
		return chargingStationService.findAllFreeStations();
	}

	@RequestMapping(value = "/station-is-free/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody boolean isFreeStation(@PathVariable("id") Long id) {
		return chargingStationService.isFree(id);
	}
}
