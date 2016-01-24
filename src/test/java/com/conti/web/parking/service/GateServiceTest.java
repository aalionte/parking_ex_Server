package com.conti.web.parking.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.conti.web.parking.model.Gate;
import com.conti.web.parking.repo.GateDao;
import com.conti.web.parking.service.impl.GateServiceImpl;

public class GateServiceTest {

	@InjectMocks
	GateServiceImpl service;

	@Mock
	GateDao gateDao;

	private static final Long ID1 = (long) 1;
	private static final String GATE_NAME_1 = "Gate1";

	@Before
	public void setup() {
		service = new GateServiceImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getListOfGates() {
		// given
		final List<Gate> gates = new ArrayList<>();
		gates.add(new Gate(ID1, GATE_NAME_1));
		// when
		Mockito.when(gateDao.findAll()).thenReturn(gates);
		// then
		assertEquals(gates, service.getAllGates());
	}

	@Test
	public void getGateByName() {
		// given
		final Gate gate = new Gate(ID1, GATE_NAME_1);
		// when
		Mockito.when(gateDao.findByName(GATE_NAME_1)).thenReturn(gate);
		// then
		assertEquals(gate, service.getGateByName(GATE_NAME_1));
	}

}
