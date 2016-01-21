package com.conti.web.service;

import org.springframework.stereotype.Service;

import com.conti.web.parking.model.Gate;

@Service
public interface GateService {

	public Gate getGateByName(String gateName);
}
