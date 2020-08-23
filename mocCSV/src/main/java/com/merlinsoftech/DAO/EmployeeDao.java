package com.merlinsoftech.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.merlinsoftech.model.Employee;
import com.merlinsoftech.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Iterable<Employee> findAll(){
		return employeeRepository.findAll();
	}
}
