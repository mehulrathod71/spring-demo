package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.service.EmployeeService;

import jdk.jfr.ContentType;

public class EmployeeControllerTest {
	
	@InjectMocks
	EmployeeController employeeController;

	@Mock
	EmployeeService employeeService;
	
	MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
	}
	
	@Test
	public void get_all_employees() {
		List<String> employees = ArrayList<String>();
		employees.add("test1");
		employees.add("test2");
		when(employeeService.getAllEmployees()).thenReturn(employees);
		
		mockMvc.perform(get("/emp")).andExpect(status().isOk())
		.andExpect(matcher)
		
	}
	
	
	
}
