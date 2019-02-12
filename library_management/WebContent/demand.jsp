<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DEMAND FOR A BOOK</title>
</head>
<center><h1>DEMAND FOR A BOOK</h1></center>
<body background="image.jpeg">
<form method="post" action="DemandServlet" >
<center>
Id of book : <input type="text" name = "idBook"><br><br>
Id of student : <input type="text" name = "idStudent"><br><br>
Name of student : <input type="text" name = "nameStudent"><br><br>
<input type="submit" value = "demand">
<input type="reset" value = "reset"> 
</center>
</form>
</body>
</html>