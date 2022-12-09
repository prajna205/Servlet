<%@ page import="com.nt.bean.*,com.nt.service.*"%>

<!-- create/locate java bean class object -->
<jsp:useBean id="emp" class="com.nt.bean.Employee" scope="request"></jsp:useBean>

<!-- write form data to java bean object -->
<jsp:setProperty name="emp" property="*" />

<!-- create/locate service class object -->
<jsp:useBean id="service" class="com.nt.service.PaySlipGenerateService"
	scope="application" />

<!-- invoke service method -->
<%
service.generatePaySlip(emp);
%>

<!-- read the inputs and results from java bean obj and display on the browser -->
<h1>Payslip</h1>
<table>
	<tr>
		<td>Employee name::</td>
		<td><jsp:getProperty property="ename" name="emp"/></td>
	</tr>
	<tr>
		<td>Employee address::</td>
		<td><jsp:getProperty property="eaddrs" name="emp"/></td>
	</tr>
	<tr>
		<td>Employee basic salary::</td>
		<td><jsp:getProperty property="basicSalary" name="emp"/></td>
	</tr>
	<tr>
		<td>Employee gross salary::</td>
		<td><jsp:getProperty property="grossSalary" name="emp"/></td>
	</tr>
	<tr>
		<td>Employee net salary::</td>
		<td><jsp:getProperty property="netSalary" name="emp"/></td>
	</tr>
</table>

<br>
<br>
<a href="emp_details.html"></a>