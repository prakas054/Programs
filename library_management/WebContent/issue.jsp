<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page import ="java.sql.Connection"%>
<%@ page import ="java.sql.DriverManager"%>
<%@ page import ="java.sql.PreparedStatement"%>
<%@ page import ="java.sql.ResultSet"%>
<%@ page import= "java.sql.SQLException"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="image.jpeg">
<center><marquee><h2>LIST OF DEMAND </h2></marquee> </center>
<form method="post" action="IssueServlet" id="myform"  >
<center>
<table class = "table" border="1"  cellpadding="5"  width="500">
   <thead>
      <tr bgcolor="C1FEFA">
         <th>Demand id</th>
         <th> Id of book</th>
         <th> Id of student</th>
         <th> Name of student</th>
         <th> issue</th>
      </tr>
</thead>
<tbody>
     <%
        String url= "jdbc:mysql://localhost:3306/library_management?useSSL=false";
		String user= "root";
		String pwd= "root";
		String driver="com.mysql.cj.jdbc.Driver";
		String qry =" select * from demandlist ";
        Connection connection=null;
		
        try{
			Class.forName(driver);	
			connection=DriverManager.getConnection(url, user, pwd);
			PreparedStatement P=connection.prepareStatement(qry);
            ResultSet rs=  P.executeQuery();
            while (rs.next()) 	{	
     %>
     
     <tr>
     <td bgcolor="C1FEFA"><%= rs.getInt(1)%></td>
     <td bgcolor="C1FEFA"><%= rs.getString(2)%></td>
     <td bgcolor="C1FEFA"><%= rs.getString(3)%></td>
     <td bgcolor="C1FEFA"><%= rs.getString(4)%></td>
    <td bgcolor="C1FEFA"><input type="submit" value = "issue" onclick="getId(<%= rs.getString(1) %>)"></td>
 
     </tr>
     <%}
		}
		catch (ClassNotFoundException |SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			if(connection != null)
			{
				try{
					connection.close();	
				}
				catch(SQLException e){
					e.printStackTrace();		
				}
			}		
		}
      %>

 </tbody>
 </table>
 </center>
 </form>
 <script type="text/javascript">
 function getId(value) {

		var x =document.getElementById("myform");
		var newElement = document.createElement("input");
	    newElement.setAttribute('id', "gettingId");
	    newElement.setAttribute('name', "demand_id");
	    newElement.setAttribute('value', value);
	  
	    x.appendChild(newElement);
		x[0].submit();
}

 </script>
 
 </body>
 </html>