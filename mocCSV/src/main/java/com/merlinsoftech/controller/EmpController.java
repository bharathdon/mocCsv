package com.merlinsoftech.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.merlinsoftech.model.Employee;
import com.merlinsoftech.service.EmployeeService;

@Controller

public class EmpController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");

		String fileName = "emp.csv";

		String headerKey = "content-Disposition";
		String headerValue = "attachment; filename=" + fileName;
		response.setHeader(headerKey, headerValue);

		Iterable<Employee> findAll = employeeService.findAll();

		CsvBeanWriter beanWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

		String[] csvHeader = { "eno", "name", "salary", "gender", "address" };
		String[] nameMapping = { "eno", "name", "salary", "gender", "address" };

		beanWriter.writeHeader(csvHeader);

		for (Employee emp : findAll) {
			beanWriter.write(emp, nameMapping);
		}

		beanWriter.close();
		return "abc.html";

	}
}
