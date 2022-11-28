package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class CustomerRegistrationServlet extends HttpServlet {
	private static String CUSTOMER_INSERT_QUERY = "INSERT INTO SERVLET_CUSTOMER VALUES(CUST_SEQ.NEXTVAL,?,?,?,?)";
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw = res.getWriter();
		//set result content type
		res.setContentType("text/html");
		//get request param values(form data)
		String name= req.getParameter("cname");
		String addrs = req.getParameter("cadd");
		float biillamt = Float.parseFloat(req.getParameter("billamt"));
		Long mobno = Long.parseLong(req.getParameter("mobno"));
		//get pooled jdbc con obj
		try (Connection con = getPooledConnection();
			PreparedStatement ps = con.prepareStatement(CUSTOMER_INSERT_QUERY)){
			//set values to query params
			ps.setString(1, name);
			ps.setString(2, addrs);
			ps.setFloat(3, biillamt);
			ps.setLong(4, mobno);
			//execute query
			int result = ps.executeUpdate();
			//process the result
			if(result==1)
				pw.println("<h1 style='color:green'>Customer Registration Successful!!!</h1?");
			else
				pw.println("<h1 style='color:green'>Customer Registration Failed!!!</h1?");
			//add home hyperlink
			pw.println("<br><br><h2><a href='customer_register.html'>Back to Home</a></h2>");
			//close stream
			pw.close();
		}//try
		catch (SQLException se) {
			se.printStackTrace();
			pw.println("<h2>Internal Problem...Try again</h2><br>"+ se.getMessage());
			pw.println("<br><br><h2><a href='customer_register.html'>Back to Home</a></h2>");
		} catch (Exception e) {
			e.printStackTrace();
			pw.println("<br><h2>Internal Problem...Try again</h2><br>b"+ e.getMessage());
			pw.println("<br><br><h2><a href='customer_register.html'>Back to Home</a></h2>");
		}
		
	}//doGet
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	//helper method
	private Connection getPooledConnection()throws Exception {
		//create initialcontext object
		InitialContext ic = new InitialContext();
		/*get datasource object through lookup operation
		DataSource ds = (DataSource)ic.lookup("java:/comp/env/DsJndi");*/
		//get ds jndi name from servlet init param
		String jndiName = getServletConfig().getInitParameter("Jndi");
		DataSource  ds = (DataSource)ic.lookup(jndiName);
		//get pooled jdbc connection
		Connection con = ds.getConnection();
		return con;
	}//getpolledconnection
}
