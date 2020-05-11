<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String id=request.getParameter("userId");
String driverName="com.mysql.jdbc.Driver";
String connectionUrl="jdbc:mysql://localhost:3306/";
String dbName="medicalmonitoringsystem";
String userId="root";
String password="VInnynaidu11*";
try{
	Class.forName(driverName);
}catch(ClassNotFoundException e){
	e.printStackTrace();
}
Connection connection=null;
Statement statement=null;
ResultSet rs=null;
%>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
</tr>
<tr>
<td><b>first_name</b></td>
<td><b>last_name</b></td>
<td><b>gender</b></td>
<td><b>phone_number</b></td>
<td><b>branch_admin_id</b>
</tr>
<%
try{
	connection=DriverManager.getConnection(connectionUrl+dbName,userId,password);
	statement=connection.createStatement();
	String sql="SELECT first_name,last_name,gender,phone_number,branch_admin_id FROM branchadmin";
	rs=statement.executeQuery(sql);
	while(rs.next()){
%>
<tr>
<td><%=rs.getString("first_name") %></td>
<td><%=rs.getString("last_name") %></td>
<td><%=rs.getString("gender") %></td>
<td><%=rs.getString("phone_number") %></td>
<td><%=rs.getString("branch_admin_id") %></td>
</tr>
<% 	
	}
	connection.close();
}catch(Exception e){
	e.printStackTrace();
}

%>
</table>






