
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@page import="java.util.List,com.zee.Customer"%>
<%@page isELIgnored="false"%>
<html>
<body>
	<h3>Customer-List</h3>
	<hr>
	<table border="2">
		<tr>

			<th>Email</th>
			<th>Password</th>
			<th>Cname</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Mobile</th>
			<th>Display-Profile</th>
		</tr>
		<jstl:forEach items="${clist}" var="customer">

			<tr>
				<td>${customer.email }</td>
				<td>${customer.password}</td>
				<td>${customer.cname}</td>
				<td>${customer.address}</td>
				<td>${customer.city}</td>
				<td>${customer.state}</td>
				<td>${customer.mobile}</td>
				<%-- <td>${customer.f1}</td> --%>
				<td><img width="30" height="30"	src="loadimage?email=${customer.email}" /></td>


			</tr>
		</jstl:forEach>
	</table>
	
	<hr>
	<a href="transporterhome">Back</a>
	<hr>
</body>
</html>