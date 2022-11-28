package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s2url")
public class Servlet2 extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw= res.getWriter();
		//set response comntent type
		res.setContentType("text/html");
		//read  and display request attribute
		pw.println("<b>Servlet2:: attr1(req) value:: " + req.getAttribute("attr1")+ "</b>");
		//read  and display session attribute
		HttpSession ses = req.getSession();
		pw.println("<br><b>Servlet2:: attr2(session) value:: " + ses.getAttribute("attr2")+ "</b>");
		//read  and display servlet context attribute
		ServletContext sc= getServletContext();
		pw.println("<br><b>Servlet2:: attr3(servlet context) value:: " + sc.getAttribute("attr3")+ "</b>");
		//forward request to servlrt2
		RequestDispatcher rd = req.getRequestDispatcher("/s3url");
		rd.forward(req, res);
		
	}//doget
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}//class
