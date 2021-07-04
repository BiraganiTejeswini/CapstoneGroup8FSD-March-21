package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.model.State;
import com.hcl.services.IState;

@CrossOrigin
@RestController
@RequestMapping("/api/v2")
public class StateController {

	@Autowired
	IState stateService;

//to get list of all states
	@GetMapping("/getAllStates")
	public List<State> displayStates() {
		List<State> ls = stateService.getAllStates();
		return ls;
	}
}
