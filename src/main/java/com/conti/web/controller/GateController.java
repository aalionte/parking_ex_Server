package com.conti.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.conti.web.parking.utils.Direction;
import com.conti.web.service.GateService;

@RestController
public class GateController {

	@Autowired
	GateService gateService;

	@RequestMapping(path = "/gate", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public String gateIsActivated(String gateName, Direction direction) {
		gateService.gateEvent(gateName, direction);
		return "hello";
	}
}
