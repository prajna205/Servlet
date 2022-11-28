package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeSearchServlet extends HttpServlet{
	private static String EMP_DETAILS_QUERY ="SELECT EMPNO,ENAME,SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read data from req Object
		//get access to servlet config
		ServletConfig cg= getServletConfig();
		//read servlet init parameters
		String driver=cg.getInitParameter("driverclass");
		String url=cg.getInitParameter("url");
		String user=cg.getInitParameter("dbuser");
		String pwd=cg.getInitParameter("dbpwd");
		
		//read form data
		int eno=Integer.parseInt(req.getParameter("empno"));
		//load jdbc driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}
		//create connection obj 
		try (Connection con=DriverManager.getConnection(url,user,pwd);
				PreparedStatement ps = con.prepareStatement(EMP_DETAILS_QUERY)){
			if(ps!=null)
				ps.setInt(1, eno);
			try (ResultSet rs= ps.executeQuery()){
				if (rs!=null) {
					if (rs.next()) {
						pw.println("<h1 style='color:blue;text-align:center'>Employee Details:::</h1>");
						pw.println("<p style='text-align:center'><b>Employee No:::"+ rs.getInt(1)+ "<b><br>");
						pw.println("<b>Employee name:::"+ rs.getString(2)+ "</b><br>");
						pw.println("<b>Employee Salary:::"+ rs.getFloat(3)+ "</b><br>");
						pw.println("<b>Employee Job:::"+ rs.getString(4)+ "</b><br>");
						pw.println("<b>Employee department No:::"+ rs.getInt(5)+ "</b></p>");
					}//if
					else {
						pw.println("<h1 style='color:red;text-align:center'>Employee Not Found...Try again...</h1>");
					}//else
				}//if
				pw.println("<p style='text-align:center'><a href='search.html'>Home</a></p>");
				//close stream
				pw.close();
			}//try resultset 
		}//try connection
		catch (SQLException se) {
			se.printStackTrace();
		}//catch
	}//doget
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//dopost
}
