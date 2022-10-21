package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCapitalServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		int country = Integer.parseInt(req.getParameter("country"));
		String[] capitals = {"new delhi","Washington, D.C.","china"};
		pw.println("<h1 style=text-align:center;color:blue>Capital :: "+ capitals[country] + "</h1>");
		//add home hyperlink
		pw.println("<a href ='page.html'>Back to Home</a>");
		//close pint writer
		pw.close();
	}//doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
