<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.cts.mms.util.ConnectionHandler" %>
<%@page import="com.cts.mms.dao.AdminMedicineDao" %>
<%@page import="com.cts.mms.model.AdminMedicine" %>
<%@page import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

 
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>
</tr>
<tr>
<td><b>medicine_name</b></td>
<td><b>medicine_id</b></td>
<td><b>medicine_usage</b></td>
<td><b>action</b></td>

</tr>

<c:forEach items="${sessionScope.List}" var="u">  
<tr><td>${u.getMedicineName()}</td><td>${u.getMedicineId()}</td><td>${u.getMedicineUsage()}</td>  
<td><a href="AdminUpdateMedicine1?medicineId=${u.getMedicineId()}">edit <i class='fas fa-edit'></i></a></td>



</tr>
</c:forEach>
</table>

