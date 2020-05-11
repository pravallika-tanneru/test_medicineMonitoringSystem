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
<td><b>medicine_name</b></td>
<td><b>medicine_id</b></td>
<td><b>medicine_usage</b></td>
</tr>
<%
try{
	connection=DriverManager.getConnection(connectionUrl+dbName,userId,password);
	statement=connection.createStatement();
	String sql="SELECT * FROM medicines";
	rs=statement.executeQuery(sql);
	while(rs.next()){
%>
<tr>
<td><%=rs.getString("medicine_name") %></td>
<td><%=rs.getString("medicine_id") %></td>
<td><%=rs.getString("medicine_usage") %></td>


</tr>
<% 	
	}
	connection.close();
}catch(Exception e){
	e.printStackTrace();
}

%>
</table>
