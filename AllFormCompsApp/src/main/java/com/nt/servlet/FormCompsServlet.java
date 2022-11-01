package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/formurl")
public class FormCompsServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		String name= req.getParameter("pname");
		int age= Integer.parseInt(req.getParameter("page"));
		String addrs= req.getParameter("paddrs");
		String gender= req.getParameter("gender");
		String maritalStatus= req.getParameter("ms");
		maritalStatus=(maritalStatus==null)?"single":maritalStatus;
		String qulf= req.getParameter("qulf");
		long mobno= Long.parseLong(req.getParameter("mobno"));
		String email= req.getParameter("mailid");
		String languages[]= req.getParameterValues("lang");
		if(languages==null)
			languages=new String[]{"No languages are selected"};
		String hobbies[]= req.getParameterValues("hb");
		if(hobbies==null)
			hobbies=new String[]{"No hobbies are selected"};
		String dob= req.getParameter("dob");
		String month= req.getParameter("mob");
		String time= req.getParameter("tob");
		int income= Integer.parseInt(req.getParameter("income"));
		String rating= req.getParameter("satisfaction");
		String favcolor= req.getParameter("favcolor");
		String fblink= req.getParameter("fburl");
		
		//display form data
		pw.println("<h2><b>Form Data:: </b></h2>");
		pw.println("<br><br><b>Name:: </b>"+name);
		pw.println("<br><b>Age:: </b>"+age);
		pw.println("<br><b>Address:: </b>"+addrs);
		pw.println("<br><b>Gender:: </b>"+gender);
		pw.println("<br><b>marital status:: </b>"+maritalStatus);
		pw.println("<br><b>Qualification:: </b>"+qulf);
		pw.println("<br><b>Mobile no:: </b>"+mobno);
		pw.println("<br><b>Email id:: </b>"+email);
		pw.println("<br><b>Languages Known:: </b>"+ Arrays.toString(languages));
		pw.println("<br><b>Hobbes:: </b>"+Arrays.toString(hobbies));
		pw.println("<br><b>Date Of Birth:: </b>"+dob);
		pw.println("<br><b>Month of Birth:: </b>"+month);
		pw.println("<br><b>Time of Birth:: </b>"+time);
		pw.println("<br><b>Income:: </b>"+income);
		pw.println("<br><b>Satisfied with income:: </b>"+rating);
		pw.println("<br><b>Favourite Colour:: </b>"+favcolor);
		pw.println("<br><b>Facebook link:: </b>"+fblink);
		
		//add home hyperlink
		pw.println("<h2><a href='all_form_comps.html'>Home</a></h2>");
		//close print writer
		pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
