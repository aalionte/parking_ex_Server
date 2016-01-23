package com.conti.web.parking;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ParkingApplication.class)
@WebAppConfiguration
public class ParkingApplicationTests {

	@Autowired
	ApplicationContext ctx;

	@Test
	public void contextLoads() {
		assertNotNull(this.ctx);
		assertTrue(this.ctx.containsBean("parkingApplication"));
	}

}
