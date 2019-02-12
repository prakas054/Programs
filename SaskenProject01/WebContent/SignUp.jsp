<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import=" java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Registration</title>
<script type="text/javascript">
	function myvalid() {
		var username = document.reg.un.value;
		var password = document.reg.pw.value;
		var phoneno = document.reg.mn.value;
		var email = document.reg.em.value;
		
		if (username == "") {
			alert("User name should not be empty");
			return false;
		} else if (password == "") {
			alert("password should not be empty");
			return false;
		} else if (phoneno == "") {
			alert("phone number should not be empty");
			return false;
		} else if (email== "") {
			alert("Email Id should not be empty");
			return false;
		} else
			return true;
	}
</script>
</head>


<body>
	<center>
		<h1>REGISTRATION
		</h1>
		<br> <br>

		<FORM name="reg" METHOD="POST" ACTION="reg.do">
			<TABLE>
				
				<TR>
					<TD>User Name:</TD>
					<TD><INPUT TYPE="text" NAME="un"></TD>
				</TR>
				<TR>
					<TD>PASSWORD:</TD>
					<TD><INPUT TYPE="password" name="pw"></TD>

				</TR>

				<TR>
					<TD>MobileNo:</TD>
					<TD><INPUT TYPE="text" NAME="mn"></TD>
				</TR>
				
				<TR>
					<TD>Email Id:</TD>
					<TD><INPUT TYPE="text" NAME="em"></TD>
				</TR>
				
				<tr>
					<td></td>
					<td><input type="submit" name="submit" value="Register"
						onclick="return myvalid()"> &nbsp;&nbsp;&nbsp;<input
						type="reset" value="RESET"><br>
					<br>
					<a href="login.jsp">Already Registered Login</a></td>
				</tr>

			</TABLE>


		</FORM>
	</center>
</BODY>
</html>