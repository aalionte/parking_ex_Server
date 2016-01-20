package com.conti.web.service;

import org.springframework.stereotype.Service;

import com.conti.web.parking.utils.Direction;

@Service
public interface GateService {

	public void gateEvent(String gateName, Direction direction);
}
