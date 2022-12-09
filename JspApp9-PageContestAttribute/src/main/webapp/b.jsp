
<b>from b.jsp</b><br>
<b>attr1(page scope) value::<%=pageContext.findAttribute("attr1") %></b><br>
<b>attr1(request scope) value::<%=pageContext.findAttribute("attr2") %></b><br>
<b>attr1(session scope) value::<%=pageContext.findAttribute("attr3") %></b><br>
<b>attr1(application scope) value::<%=pageContext.findAttribute("attr4") %></b><br>


<jsp:forward page="c.jsp"></jsp:forward>