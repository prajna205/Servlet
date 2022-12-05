
<%@page import="java.time.LocalDateTime"%>
<%! public String generateWishMessage(String user){
	//get system date and time 
	java.time.LocalDateTime idt = java.time.LocalDateTime.now();
	//get hour
	int hour = idt.getHour();
	//generate wish message
	if(hour<12)
		return "Good Morning " + user;
	else if(hour<16)
		return "Good afternoon " + user;
	else if(hour<20)
		return "Good evenging " + user;
	else
		return "Good Night " + user;
}
%>

<h1 style='color:red;text-align:center'>Welcome To jsp Page</h1>
<br>
<h2 style="color:green;text-align:center">Date and time is:: <%=new java.util.Date()%></h2>
<% String name="raja"; %>
<br>
<h2 style="color:purple;text-align:center"><b><%=generateWishMessage(name) %></b></h2>