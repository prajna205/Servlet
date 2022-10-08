package com.nt.servlet;

import javax.servlet.*;
import java.util.Date;
import java.io.*;

public class DateServlet extends GenericServlet{

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
	
		//get priintWriter stream obj from res obj
		PrintWriter pw = res.getWriter();
		
		//set the response content type
		res.setContentType("text/html");
		
		//write request processing logic
		Date d = new Date();//holds system date and time
		
		//write generated output to response object using printwriter stream
		pw.println("<h1>System Date and Time :" + d + "</h1>");
		
		//close the printwriter
		pw.close();
}//service
}//class