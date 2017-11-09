<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The logged in page</title>
</head>
<body>

<script>
function m1(){
	window.location("okok.jsp");
}

</script>
<% 
String s="sex" /*(String)session.getAttribute("ful")*/;
String s1= (String)session.getAttribute("idz");
%>
<div style="margin-left:80%; margin-top:5%">logged-in </div><h1 style="margin-left:80%; margin-down:80%;" ><%=s%></h1>
<input type="button" onclick="m1()" value="click">
</body>
</html>