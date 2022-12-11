package com.nt.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.model.Employee;
import com.nt.service.EmployeeMgmtServiceImpl;

@WebServlet(urlPatterns = "/controllerurl" , loadOnStartup = 1)
public class MainControllerServlet extends HttpServlet {
       EmployeeMgmtServiceImpl service;
	@Override 
	public void init() throws ServletException {
		service= new EmployeeMgmtServiceImpl();
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//get form data
		String desg=req.getParameter("job");
		String action = req.getParameter("s1");
		try {
			//invoke b.method
			List<Employee> list=service.fetchEmployeeByDesg(desg);
			//keep the results in req scope to send to view Component
			req.setAttribute("empDetails", list);
			String resultPage=null;
			if(action.equalsIgnoreCase("HtmlOutput"))
				 resultPage = "/html_screen.jsp";
			else
				 resultPage = "/excel_screen.jsp";
			//forward the request to result pae
			RequestDispatcher rd =req.getRequestDispatcher(resultPage);
			rd.forward(req, res);
		} 
		catch (SQLException se) {
			se.printStackTrace();
			RequestDispatcher rd= req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
		catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd= req.getRequestDispatcher("/error.jsp");
			rd.forward(req, res);
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
