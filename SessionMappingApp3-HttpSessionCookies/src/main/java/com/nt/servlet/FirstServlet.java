package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form1 data
		String name = req.getParameter("pname");
		String fname = req.getParameter("fname");
		String addrs = req.getParameter("addrs");
		String ms = req.getParameter("ms");
		//create/access session object for current req
		HttpSession ses = req.getSession();
		//HttpSession ses = req.getSession(true);
		//keep form1/req1 data in session obj as session attibute values
		ses.setAttribute("name", name);
		ses.setAttribute("fname", fname);
		ses.setAttribute("addrs", addrs);
		ses.setAttribute("ms", ms);
		//generate form 2 based on 
		if (ms.equalsIgnoreCase("married")) {
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table align='center'>");
			pw.println("<tr><td>Spouse Name::</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>No. Of Kids::</td><td><input type='number' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' name='Register'></td> <td><input type='Reset' name='Cancel'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");

		}//if
		else {
			pw.println("<form action="+res.encodeURL("secondurl")+" method='POST'>");
			pw.println("<table align='center'>");
			pw.println("<tr><td>Why do u want to marry::</td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>When do u want to marry::</td><td><input type='text' name='f2t2'></td></tr>");
			pw.println("<tr><td><input type='submit' name='Register'></td> <td><input type='Reset' name='Cancel'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}//else
		
		pw.println("<br> <b> session id:::"+ ses.getId()+"</b>");
		
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
