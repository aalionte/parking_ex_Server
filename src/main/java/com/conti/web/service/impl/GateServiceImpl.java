package com.conti.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.conti.web.parking.model.Gate;
import com.conti.web.parking.repo.GateDao;
import com.conti.web.service.GateService;

public class GateServiceImpl implements GateService{

	@Autowired
	GateDao gateDao;
	
	@Override
	public Gate getGateByName(String gateName) {
		return gateDao.findByName(gateName);
		
	}

}
