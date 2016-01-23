package com.conti.web.parking.service;

import java.util.List;

import com.conti.web.parking.model.Gate;


public interface GateService {

	public Gate getGateByName(String gateName);

	public List<Gate> getAllGates();
}
