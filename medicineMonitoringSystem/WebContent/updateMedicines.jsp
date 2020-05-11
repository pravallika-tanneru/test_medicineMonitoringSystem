<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" import="java.sql.*,com.cts.mms.model.AdminMedicine,com.cts.mms.dao.AdminMedicineDao,com.cts.mms.util.ConnectionHandler"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
h1 {
	color: green;
}

body {
	text-align: center;
}

table.center {
	margin-left: auto;
	margin-right: auto;
	border: "1";
}
</style>
</head>
<% AdminMedicine am=(AdminMedicine)session.getAttribute("medicine");
out.println(am.getMedicineId());
int medicineId=am.getMedicineId();
%>

<%=am.getMedicineName() %>
<%=am.getMedicineUsage()%>

${sessionScope.am.getMedicineId()}

<body>
<h1>Update Medicines</h1>
	<form action="MedicineEdit" method="post">
	<table class="center" >
	<th>Medicine Id</th>
				<td><input type="text" placeholder="medicineId can't change"
					name="medicineId" value="<%=am.getMedicineId() %>" readonly="readonly">
				<td>
			</tr>
	<tr>
	<th>Medicine Name</th>
	<td><input type="text" placeholder="enter Medicine Name" name="medicineName" value="<%=am.getMedicineName() %>" required/></td>
	</tr>
	<tr>
				
			<tr>
		<th>Medicine Usage</th>
				<td><input type="text" name="medicineUsage" placeholder="enter medicineUsage"  value="<%=am.getMedicineUsage() %>" required /></td>
					
					</tr>
	</table>
	<input type="submit" name="Update" value="Update" />
</body>
</html>