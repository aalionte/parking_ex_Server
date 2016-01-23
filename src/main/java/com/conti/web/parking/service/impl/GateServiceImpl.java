package com.conti.web.parking.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conti.web.parking.model.Gate;
import com.conti.web.parking.repo.GateDao;
import com.conti.web.parking.service.GateService;

@Service
public class GateServiceImpl implements GateService{

	@Autowired
	GateDao gateDao;
	
	@Override
	public Gate getGateByName(String gateName) {
		return gateDao.findByName(gateName);
		
	}

	@Override
	public List<Gate> getAllGates() {
		return (List<Gate>) gateDao.findAll();
	}

}
