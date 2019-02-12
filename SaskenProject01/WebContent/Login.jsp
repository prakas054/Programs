<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Welcome To Login</title>
<script type="text/javascript">
function myvalidate(){
	var username=document.myform.un.value;
	var password=document.myform.pw.value;
	if(username=="" || password==""){
		alert("AccountNo  and password are should not be empty");
		return false;
	}
	return true;
}
</script>
</head>
<body>
<br></br><br></br><br></br>
<center>
<form action="SignUp.jsp">
<table>
<TR>
    
	<TD><input type="submit" value="Sign Up"></TD>
	
</TR>
</table>

</form>
</center>

<center>
<FORM  name="myform" method="POST" ACTION="login.do">
<TABLE>
<TR>
	<TD><h1>LOGIN</h1></TD>
</TR>
<TR>
	<TD>User Name:</TD>
</TR>
<TR>	
	<TD><INPUT TYPE="text" NAME="un"></TD>
</TR>
<TR>
	<TD>Password:</TD>
</Tr>
<TR>	
	<TD><INPUT TYPE="password"  name="pw"></TD>
</TR>
<TR>
	<TD><INPUT TYPE="submit" name="submit"value="Login" onclick="return myvalidate()"></TD>
	
</TR>

</TABLE>
</FORM>
</center>
</BODY>
</HTML>