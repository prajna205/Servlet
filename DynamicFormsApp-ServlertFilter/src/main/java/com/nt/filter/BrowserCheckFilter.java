package com.nt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class BrowserCheckFilter extends HttpFilter {
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//get print writer
		PrintWriter pw= res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get browser name
		String browserName = req.getHeader("user-agent");
		if (browserName.contains("Firefox")) {
			chain.doFilter(req, res); //executes next filter or dest web comp
		}//if
		else {
			pw.println("<h1 style='color:red;text-align:center'>Request must be given from firefox browser</h1>");
			return;
		}//else
		//close stream
		pw.close();
	}//dofilter
}//class
