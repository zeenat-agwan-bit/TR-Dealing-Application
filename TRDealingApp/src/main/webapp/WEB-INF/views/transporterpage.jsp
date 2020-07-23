<%@page isELIgnored="false" %>
<html>
<body>
	<h3>WELCOME ${username}</h3>
	<hr>
	<pre>
		<a href="updatetransporterprofile?email=${email}">Update-Profile</a>
		
		<a href="vehicleentry">Add-Vehicle</a>
		
		<a href="vehiclelist">Update OR Remove Vehicle-Details</a>
		
		<a href="bookingentry">Booking</a>
		
		<a href="viewallbookings">View-My-Bookings</a>
		
		<a href="datesearch">Search-Booking-Date-wise</a>
		
		<a href= "citysearch">Search-Booking-City-wise</a>
		
                <a href="customerlist">View-All-Customers</a>
	        	  
		<hr>
		<a href="index.jsp">LOGOUT</a>
		<hr>
	</pre>
	<hr>
</body>
</html>