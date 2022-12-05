<%@ page import="java.sql.*"%>

<%!Connection con = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	private static final String INSERT_QUERY = "INSERT INTO JSP_PERSON_INFO VALUES(JSP_PID_SEQ.NEXTVAL,?,?,?)";
	private static final String SELECT_QUERY = "SELECT PID,PNAME,PAGE,EMAILID FROM JSP_PERSON_INFO";

	public void jspInit() {
		//get servlet config object
		ServletConfig cg = getServletConfig();
		//read init param values(jdbc properties)
		String driver = cg.getInitParameter("driverclass");
		String url = cg.getInitParameter("jdbcurl");
		String user = cg.getInitParameter("dbuser");
		String pwd = cg.getInitParameter("dbpwd");
		try {
			//load jdbc driver class
			Class.forName(driver);
			//establish connection
			con = DriverManager.getConnection(url, user, pwd);
			//create preparedStatement obj
			ps1 = con.prepareStatement(SELECT_QUERY);
			ps2 = con.prepareStatement(INSERT_QUERY);
		} //try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//jspInit()%>
<%
//read additional req param value
String pval = request.getParameter("p1");
if (pval.equalsIgnoreCase("register")) {
	//read form data
	String name = request.getParameter("pname");
	int age = Integer.parseInt(request.getParameter("page"));
	String mailid = request.getParameter("mail");
	//set values to query param
	ps2.setString(1, name);
	ps2.setInt(2, age);
	ps2.setString(3, mailid);
	//execute the query
	int result = ps2.executeUpdate();
	if (result == 0) {
%>
<h1 style="color: red; text-align: center">Record not inserted</h1>
<%
} else {
%>
<h1 style="color: green; text-align: center">Record inserted
	successfully</h1>
<%
}
} //if 
else {
//execute query
ResultSet rs = ps1.executeQuery();
%>
<table border="2" align="center">
	<tr>
		<th>id</th>
		<th>name</th>
		<th>age</th>
		<th>email</th>
	</tr>

	<%
	//process the result
	while (rs.next()) {
	%>
	<tr>
		<td><%=rs.getInt(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getInt(3)%></td>
		<td><%=rs.getString(4)%></td>
	</tr>
<%
} //while %>
</table>
<%  } //else %>
<h2 style='text-align: center'>
	<a href="person_form.html">Back</a>
</h2>
<%!public void jspDestroy() {
	try {
		if (ps1 != null)
			ps1.close();
	} catch (SQLException se) {
		se.printStackTrace();
	} //ps1
	try {
		if (ps2 != null)
			ps2.close();
	} catch (SQLException se) {
		se.printStackTrace();
	} //ps2
	try {
		if (con != null)
			con.close();
	} catch (SQLException se) {
		se.printStackTrace();
	} //con
}//jspDestroy()%>