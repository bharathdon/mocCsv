package com.merlinsoftech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merlinsoftech.DAO.EmployeeDao;
import com.merlinsoftech.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public Iterable<Employee> findAll(){
		return employeeDao.findAll();
	}
}
