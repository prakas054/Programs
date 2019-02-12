<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="image.jpeg">
<form method="post">

<center><h2>ADD BOOK</h2></center>

<center>

Name of book : <input type= "text" name= "name"><br><br>
Number of copy : <input type= "text" name= "copy"><br><br>
<input type= "submit" value= "add" onclick="document.forms[0].action='SecondPage'; return true;">
<input type= "reset" value= "reset"><br><br>
</center>
</form>
</body>
</html>