package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeMgmtservice {

	public List<Employee> fetchEmployeeByDesg(String desg) throws Exception;
}
