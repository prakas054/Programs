<%@page import="com.praksh.program.FirstPage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>librarian</title>
</head>
<center><h1>LIBRARIAN HOME PAGE</h1></center>
<%
if(FirstPage.x==0)
{
	response.sendRedirect("login.jsp");
}
%>
<body background="image.jpeg" >
<form>
<center>
<input type= "submit" value= "search"  onclick="document.forms[0].action='search.jsp'; return true;"><br><br>
<input type= "submit" value= "issue" onclick="document.forms[0].action='issue.jsp'; return true;"><br><br>
<input type= "submit" value= "Issued Book" onclick="document.forms[0].action='issuedBookList.jsp'; return true;"><br><br>
<input type= "submit" value= "log out" onclick="document.forms[0].action='login.jsp'; return true;"> 
</center>
</form>
</body>
</html>