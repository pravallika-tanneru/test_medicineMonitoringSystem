<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BranchAdmin</title>
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
	<h1>Registration form</h1>
	<form action="registerBranch" method="post">
		<table class="center">


			<tr>
				<th>Enter your first name</th>
				<td><input type="text" name="firstName" id="fn1" maxlength="10"
					title="enter your first name" placeholder="enter your first name"
					required /></td>
			</tr>
			<tr>
				<th>Enter your last name</th>
				<td><input type="text" name="lastName" id="ln1" maxlength="10"
					title="enter your last name" placeholder="enter your last name"
					required /></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><input type="number" name="age" title="enter your age"
					placeholder="enter your age" min="0" max="100" required /></td>
			</tr>
			<tr>
				<th>gender</th>
				<td><select name="gender">
						<option value="">select your gender</option>
						<option>Male</option>
						<option>Female</option>
						<option>others</option>
				</select></td>
			</tr>
			<tr>
				<th>phone number</th>
				<td><input type="text" id="phone" name="phoneNumber"
					pattern="[7-9]{1}[0-9]{9}" required></td>
			</tr>

			<tr>
				<th>Branch AdminId</th>
				<td><input type="text" placeholder="Enter Username"
					name="branchAdminId" required>
				<td>
			</tr>
			<tr>
				<th>password</th>
				<td><input type="password" placeholder="Enter Password"
					name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" required>
				<td>
			</tr>

		</table>
		<input type="submit" name="register" value="Register" />

	</form>

</body>
</html>