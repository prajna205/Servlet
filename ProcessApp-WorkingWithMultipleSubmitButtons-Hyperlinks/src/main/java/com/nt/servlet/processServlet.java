package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class processServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print Writer
		PrintWriter pw =res.getWriter();
		//set browser content type
		res.setContentType("text/html");
		//read special req parameter value
		String s1val= req.getParameter("s1");
		int val1=0,val2=0;
		//read text box value when request is not coming from hyperlinks
		if (!s1val.equalsIgnoreCase("link1") && !s1val.equalsIgnoreCase("link2")) {
			val1=Integer.parseInt(req.getParameter("t1"));
			val2=Integer.parseInt(req.getParameter("t2"));
		}
		//differentiate logic for submit buttons and hyperlinks
		if(s1val.equalsIgnoreCase("add"))
			pw.println("<h1>Sum of " + val1 +" and "+ val2+ " is ::: "+(val1+val2)+ "</h1>");
		else if(s1val.equalsIgnoreCase("sub"))
			pw.println("<h1>Sub of " + val1 +" and "+ val2+ " is ::: "+(val1-val2)+ "</h1>");
		else if(s1val.equalsIgnoreCase("mul"))
			pw.println("<h1>Mul of " + val1 +" and "+ val2+ " is :::"+(val1*val2)+ "</h1>");
		else if(s1val.equalsIgnoreCase("div"))
			pw.println("<h1>Sum of " + val1 +" and "+ val2+ " is :::"+((float)val1/val2)+ "</h1>");
		else if (s1val.equalsIgnoreCase("link1")) 
			pw.println("<h1>System properties are:::</h1>"+ "<b>"+ System.getProperties()+ "</b>");
		else
			pw.println("<h1>System date and Time :::"+LocalDateTime.now() + "</h1>");
		
		//add hyperlink
		pw.println("<br><br><a href='process.html'>Back to Home</a>");
		
		//close printWriter
		pw.close();
	}//do-get
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
