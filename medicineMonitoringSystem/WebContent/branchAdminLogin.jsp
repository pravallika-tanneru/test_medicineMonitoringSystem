<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="BranchAdminLogin" method="post">
		
  <table style="background-color: lightgreen; margin-left:20px;margin-left:20px;">
   <tr><td><h2 style="color:green;">Login to your account</h2></td></tr>
    <tr><td>Branch Admin Id: </td><td> <input type="text" name="branchAdminId" ></td></tr>
   <tr><td> password: </td><td><input type="password" name="password"></td></tr>
    
    <tr><td><input type="submit" name="login" value="login"></td></tr>
    
  </table>
	</form>
</body>
</html>