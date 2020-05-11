<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
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
<body>
<h1>Update Medicines</h1>
	<form action="registerBranchMedicine" method="post">
	<table class="center" >
	<tr>
	<th>Branch Name</th>
	<td><input type="text" placeholder="Branch Name" name="branchName" required></td></tr>
	<tr>
	<th>Medicine Name</th>
	<td><input type="text" placeholder="Enter Medicine Name" name="medicineName" required></td>
	</tr>
	<tr>
				<th>Medicine Id</th>
				<td><input type="text" placeholder="Enter MedicineId"
					name="medicineId" required>
				<td>
			</tr>
			<tr>
		<th>Medicine Usage</th>
				<td><input type="text" name="medicineUsage" id="medicineUsage" maxlength="100" required /></td>
					
					</tr>
	</table>
	<input type="submit" name="register" value="Register" />
</body>
</html>