package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginurl")
public class LoginServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print Writer
		PrintWriter pw =res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		String mail=req.getParameter("gmail");
		String pwd = req.getParameter("pwd");
		//write b.logic
		if (mail.equalsIgnoreCase("prajna@gmail.com") && pwd.equalsIgnoreCase("bini")) {
			pw.println("<h1 style = 'green;text-align:center'>valid credentials</h1>");
		}
		else {
			pw.println("<h1 style = 'color:red;text-align:center'>invalid credentials</h1>");
		}
		//add home  hyperlink
		pw.println("<a href='login.html'>Back to home</h1>");
		//close stream
		pw.close();
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
