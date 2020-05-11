<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Page Title</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  margin: 0;
}

/* Style the header */
.header {
  padding: 80px;
  text-align: center;
  background: #1abc9c;
  color: white;
}

/* Increase the font size of the h1 element */
.header h1 {
  font-size: 40px;
}
table.center {
	margin-left: auto;
	margin-right: auto;
	border: "1";
}
</style>
</head>
<body>

<div class="header">
  <h1>Admin Home Page</h1>
  <table>
  <tr><button type="submit"  class="w3-button w3-round-xlarge"><a href="medicineDetails1.jsp">Medicine Details</a></button></td></tr><br>
  <br>
  <tr><button type="submit"  class="w3-button w3-round-xlarge"><a href="branchAdminDetailsData.jsp">Branch Admin List</a></button></tr><br>
  <br>
  <tr><button type="submit" class="w3-button w3-round-xlarge"><a href="AdminUpdateMedicine">Update Stocks</a></button></tr><br>
  </table><br>
  <button type="submit" class="w3-button w3-round-xlarge"><a href="index.jsp">Logout</a></button>
</div>

</body>
</html>
