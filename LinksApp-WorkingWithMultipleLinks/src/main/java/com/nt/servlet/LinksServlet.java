package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinksServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print Writer
		PrintWriter pw =res.getWriter();
		//set browser content type
		res.setContentType("text/html");
		//read additional req parameter value
		String rval= req.getParameter("p1");
		//get all available locales
		Locale locales[] = Locale.getAvailableLocales();
		//different logics for hyperlinks
		if (rval.equalsIgnoreCase("link1")) {
			pw.println("<h1>All Countries:</h1>");
			for (Locale locale : locales) {
				pw.println(locale.getDisplayCountry());
			}
		}//if
		else if (rval.equalsIgnoreCase("link2")) {
			pw.println("<h1>All Languages:</h1>");
			for (Locale locale : locales) {
				pw.println(locale.getDisplayLanguage());
			}
		}//else-if
		else {
			pw.println("<h1>System date and time:::" + LocalDateTime.now() +"</h1>");
		}
		//add hyperlink
		pw.println("<br><br><a href='links.html'>Back to Home</a>");
		
		//close printWriter
		pw.close();
	}//do-get
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
