

<% 
//read  req param value
String ss= request.getParameter("ss");

//perform send redirection
response.sendRedirect("https://www.google.com/search?q="+ss);
%>