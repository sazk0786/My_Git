<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String s=(String)session.getAttribute("ful");
String s1= (String)session.getAttribute("idz");
%>
<div style="margin-left:80%; margin-top:5%">logged-in </div><h1 style="margin-left:80%; margin-down:80%;" ><%=s%></h1>
<br>
<br>
full_name is <%=s %>
and corresponding id:<%=s1 %>
</body>
</html>