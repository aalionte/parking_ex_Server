package com.conti.web.parking;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.conti.web.parking.controller.GateController;
import com.conti.web.parking.model.Gate;
import com.conti.web.parking.service.GateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class GateControllerTest {

	MockMvc mockMvc;
	ObjectWriter jsonWriter;

	@InjectMocks
	GateController gateController;

	@Mock
	GateService service;

	@Before
	public void setup() throws IOException {
		jsonWriter = new ObjectMapper().writer();

		MockitoAnnotations.initMocks(this);

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/view/");
		viewResolver.setSuffix(".jsp");

		mockMvc = MockMvcBuilders.standaloneSetup(gateController).setViewResolvers(viewResolver).build();
	}

	@Test
	public void shouldReturnAListOfGates() throws Exception {
		// given
		List<Gate> gatesList = new ArrayList<>();
		gatesList.add(new Gate((long) 1, "Gate1"));
		gatesList.add(new Gate((long) 2, "Gate2"));

		// then
		Mockito.when(gateController.getAllGates()).thenReturn(gatesList);

		// then
		mockMvc.perform(get("/gates")).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}

	@Test
	public void shouldReturnDetailsAboutGate() throws Exception {
		// given
		final String gateName=  "Gate1";
		Gate gate = (new Gate((long) 1, gateName));

		//then
		Mockito.when(gateController.getDetailsAboutGate(gateName)).thenReturn(gate);
		
		//when
		mockMvc.perform(get("/gates/gate/{gateName}", gateName)).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}
	

}
