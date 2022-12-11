package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.model.Employee;

public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPLOYEE_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?"; 

	@Override
	public List<Employee> getEmpsByDesg(String desg) throws Exception{
		List<Employee> list = null; 
		try(Connection con = getPolledConnetion();
			PreparedStatement ps = con.prepareStatement(GET_EMPLOYEE_BY_DESG)){
			ps.setString(1, desg);
			try (ResultSet rs= ps.executeQuery()){
				//convert rs object records to list of emp obj
				list = new ArrayList<Employee>();
				while (rs.next()) {
					Employee emp =new Employee();
					emp.seteNo(rs.getInt(1));
					emp.seteName(rs.getString(2));
					emp.setDesg(rs.getString(3));
					emp.setSalary(rs.getFloat(4));
					list.add(emp);
				}//while 
			}//try rs 	
		} //try con
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return list;
	}
	//helper method
	private Connection getPolledConnetion() throws Exception{
		InitialContext ic =new InitialContext();
		DataSource ds = (DataSource)ic.lookup("java:/comp/env/DsJndi");
		return ds.getConnection();
	}

}
