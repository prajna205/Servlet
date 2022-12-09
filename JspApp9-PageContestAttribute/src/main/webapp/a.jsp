
<b>from a.jsp</b><br>
<%
//create 4 scope attributes
//page scope
pageContext.setAttribute("attr1", "val1");
//request scope
pageContext.setAttribute("attr2", "val2", pageContext.REQUEST_SCOPE);
//session scope
pageContext.setAttribute("attr3", "val3", pageContext.SESSION_SCOPE);
//application scope
pageContext.setAttribute("attr4", "val4", pageContext.APPLICATION_SCOPE);
%>

<jsp:forward page="b.jsp"></jsp:forward>