package com.conti.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.conti.web.parking.model.Gate;
import com.conti.web.service.GateService;

@Controller
public class GateController {

	@Autowired
	GateService gateService;

	@RequestMapping(path = "/gate/{gateName}", method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Gate gateIsActivated(@RequestParam(value = "name") String gateName) {
		return gateService.getGateByName(gateName);
	}
}
