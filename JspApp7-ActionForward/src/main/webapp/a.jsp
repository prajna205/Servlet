

<b>start of a.jsp</b>
<br>
<% float price = 500 + 500 * 0.1f; %>
<jsp:forward page="b.jsp">
	<jsp:param name="bookname" value="JAVA"/>
	<jsp:param name="cost" value="<%=price %>" />
</jsp:forward>
<br>
<b>end of a.jsp</b>