package com.conti.web.parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.conti.web.parking.model.Gate;
import com.conti.web.parking.service.GateService;

@Controller
@RequestMapping(value = "/gates")
public class GateController {

	@Autowired
	GateService gateService;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Gate> getAllGates() {
		return gateService.getAllGates();
	}

	@RequestMapping(value = "/gate/{gateName}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Gate gateIsActivated(@PathVariable("gateName") String gateName) {
		return gateService.getGateByName(gateName);
	}
	
	
}
