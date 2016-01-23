package com.conti.web.parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.conti.web.parking.service.ParkingPlaceService;

@RestController
public class StatisticsController {

	@Autowired
	ParkingPlaceService service;

	@RequestMapping(value = "/live")
	@ResponseBody
	public ModelAndView liveResults() {
		ModelAndView model = new ModelAndView("index");
		model.addObject("total", service.getTotal());
		model.addObject("freePlaces", service.countFreeParkingPlaces());
		return model;

	}
}
