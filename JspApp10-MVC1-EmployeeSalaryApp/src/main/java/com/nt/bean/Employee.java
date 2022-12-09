package com.nt.bean;

import java.io.Serializable;

public class Employee implements Serializable {
	private String ename;
	private String eaddrs;
	private float basicSalary;
	private float grossSalary;
	private Float netSalary;
	//settersand getters
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEaddrs() {
		return eaddrs;
	}
	public void setEaddrs(String eaddrs) {
		this.eaddrs = eaddrs;
	}
	public float getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}
	public float getGrosssalary() {
		return grossSalary;
	}
	public void setGrosssalary(float grossSalary) {
		this.grossSalary = grossSalary;
	}
	public Float getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Float netSalary) {
		this.netSalary = netSalary;
	}
	
}
