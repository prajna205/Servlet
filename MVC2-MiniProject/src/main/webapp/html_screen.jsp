<%@ page import="java.util.*,com.nt.model.*"%>

<%
List<Employee> list = (List<Employee>)request.getAttribute("empDetails");
String desg = request.getParameter("job");
%>
<%if (list != null && list.size() != 0) {
	int i = 1;
	%>

<h3 style="color: red; text-align: center">Employee Details::</h3>
<table>
	<tr>
		<th>Sno</th>
		<th>EmpNo</th>
		<th>Empname</th>
		<th>Desg</th>
		<th>Salary</th>
		<th>Grosssalary</th>
		<th>Netsalary</th>
	</tr>
	<%
	for (Employee emp : list) {
	%>
	<tr>
		<td><%=i++%></td>
		<td><%=emp.geteNo()%></td>
		<td><%=emp.geteName()%></td>
		<td><%=emp.getDesg()%></td>
		<td><%=emp.getSalary()%></td>
		<td><%=emp.getGrossSalary()%></td>
		<td><%=emp.getNetSalary()%></td>
	</tr>
	<%
	}
	%>
</table>
<%
} else {
%>
<h3 style="color: red; text-align: center">Records not found...<%=list.size() %></h3>

<%} %>
