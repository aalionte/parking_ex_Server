package com.conti.web.parking.repo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.conti.web.parking.ParkingApplication;
import com.conti.web.parking.model.Gate;

@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = ClassMode.AFTER_CLASS)
@SpringApplicationConfiguration(classes = ParkingApplication.class)
@Transactional
public class GateDaoTest {

	@Autowired
	GateDao gateDao;

	private List<Gate> gatesList;
	private static final Long ID1 = (long) 1;
	private static final String GATE_NAME_1 = "Gate1";

	@Before
	public void setUp() throws Exception {
		gatesList = new ArrayList<>();
		gatesList.add(new Gate(ID1, GATE_NAME_1));
		gateDao.save(gatesList);
	}

	@After
	public void tearDown() {
		gateDao.deleteAll();
	}

	@Test
	// TODO : rewrite this test with a dedicated database for tests
	public void shouldReturnListOfGates() {
		// when
		List<Gate> gates = (List<Gate>) gateDao.findAll();
		// then
		assertEquals(4, gates.size());
	}

	@Test
	public void shouldReturnGateDetails() {
		// when
		Gate gate = gateDao.findByName(GATE_NAME_1);

		assertEquals(ID1, gate.getId());
	}

}
