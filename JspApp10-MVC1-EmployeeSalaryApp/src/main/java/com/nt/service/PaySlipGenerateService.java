package com.nt.service;

import com.nt.bean.Employee;

public class PaySlipGenerateService {

	public void generatePaySlip(Employee emp) {
		//calculate gross and net salary
		float grossSalary = emp.getBasicSalary() + (emp.getBasicSalary()*0.4f);
		float netSalary = grossSalary - (grossSalary*0.2f)	;
		//set the values back to emp class obj
		emp.setGrosssalary(grossSalary);
		emp.setNetSalary(netSalary);
	}
}
