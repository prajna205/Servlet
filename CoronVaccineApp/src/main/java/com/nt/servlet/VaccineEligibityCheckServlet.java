package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class VaccineEligibityCheckServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get the print writer
		PrintWriter pW =res.getWriter();
		//set the content type
		res.setContentType("text/html");
		//read form data(req parameter values)
		String name= req.getParameter("pname");
		String addrs= req.getParameter("paddr");
		int age= Integer.parseInt(req.getParameter("page"));
		
		//business logic(request processing logic)
		if(age<18)
			pW.println("<h1 style='color:red ; text-align:center'>Hello "+ name+"U are not eligible for vaccination</h1>");
		else
			pW.println("<h1 style='color:red ; text-align:center'>Hello "+ name+"U are eligible for vaccination</h1>");
		
		//add hyperlink to navigate to home page 
		pW.println("<a href = 'http://localhost:3030/CoronaVaccineApp/corona_vaccine.html><img src='images/home.png'></a>");
		//close print writer
		pW.close();
	}

}
