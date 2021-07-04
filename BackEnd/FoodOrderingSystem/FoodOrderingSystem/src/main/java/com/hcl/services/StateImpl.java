package com.hcl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.State;
import com.hcl.repositry.IStateDAO;

@Service
public class StateImpl implements IState {
	@Autowired
	IStateDAO stateDAO;

//to get all states details
	@Override
	public List<State> getAllStates() {

		return stateDAO.findAll();
	}

}
