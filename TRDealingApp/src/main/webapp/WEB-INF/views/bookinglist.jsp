<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
	<%@ page isELIgnored="false"%>
	<html>
	<body>
	<h3>Booking-Deals</h3>
	<hr>
	<table border="2">
		<tr>
		<th>BCode</th><th>From</th><th>To</th><th>Date</th><th>Fare</th><th>VType</th><th>VRegno</th>
		<tr>
		<jstl:forEach items="${bookings}" var="booking"> 

		<tr>
		<td>${booking.bcode}</td>
		<td>${booking.sourceCity}</td>
		<td>${booking.destCity}</td>
		<td>${booking.date}</td>
		<td>${booking.fare}</td>
		<td>${booking.vehicle.vtype}</td>
		<td>${booking.vehicle.regno}</td>
		
		
		<tr>
		</jstl:forEach>		
	</table>
	<hr>
	<a href="transporterhome">Back</a>
	<hr>
	<a href="customerhome">Customer-Home</a>
	</body>
	</html>
	