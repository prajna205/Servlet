package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {       

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form2/req2 data
		String f2val1 = req.getParameter("f2t1");
		String f2val2 = req.getParameter("f2t2");
		//get access to http session object
		HttpSession ses=req.getSession(false);
		//read form1/req1 data from session obj
		String name=(String)ses.getAttribute("name");
		String fname=(String)ses.getAttribute("fname");
		String addrs=(String)ses.getAttribute("addrs");
		String ms=(String)ses.getAttribute("ms");
		//display form1/req1 data
		pw.println("<br><b>Person Details:::"+ name+ "..."+ fname+ "..."+ addrs+ "..."+ 
					ms+ "..."+ f2val1+ "..."+ f2val2+"</b>");
	
		//invalidate the session
		ses.invalidate();
		//add home hyperlink
		pw.println("<br><br><a href='person_details.html'>Home</a>");
		
		pw.println("<br> <b> session id:::"+ ses.getId()+"</b>");
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
