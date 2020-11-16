<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<%@page import="java.util.List, com.zee.domain.Customer "%>
<%@page isELIgnored="false"%>
<html>
<body>
	<h3>Customer-List</h3>
	<hr>
	<table border="2">
		<tr>

			<th>Email</th>
			<th>Password</th>
			<th>Cname</t>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Mobile</th>
			<th>Display-Profile</th>
		</tr>
		<jstl:forEach items="${clist}" var="customers">

			<tr>
				<td>${customers.email }</td>
				<td>${customers.password}</td>
				<td>${customers.cname}</td>
				<td>${customers.address}</td>
				<td>${customers.city}</td>
				<td>${customers.state}</td>
				<td>${customers.mobile}</td>
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