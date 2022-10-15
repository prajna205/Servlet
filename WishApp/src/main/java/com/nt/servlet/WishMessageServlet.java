package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishMessageServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get print writer
		PrintWriter pw = res.getWriter();
		//create business logic to generate wish messgae
		LocalDateTime ldt = LocalDateTime.now();
		int hour =ldt.getHour();
		pw.println("<h1 style='text-align:center;color:red'>Local Date and Time :::"+ldt.toString()+ "</h1>");
		if(hour<12)
			pw.println("<h1 style='text-align:center;color:blue'>Good Morning</h1>");
		else if(hour > 12 && hour<16)
			pw.println("<h1 style='text-align:center;color:green'>Good Afternoon</h1>");
		else if(hour>16 && hour > 20)
			pw.println("<h1 style='text-align:center;color:orange'>Good Evening</h1>");
		else 
			pw.println("<h1style='text-align:center;color:sky'>Good Night</h1>");
		//set url to move to page.html
		pw.println("<a href='http://localhost:3030/WishApp/page.html'>Home</a>");
		//close printWriter obj
		pw.close();
		
	}//service
}//class
