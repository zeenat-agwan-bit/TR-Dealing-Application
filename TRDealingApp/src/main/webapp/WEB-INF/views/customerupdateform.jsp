<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page isELIgnored="false"%>

<html>
<body>
	<h3>UPDATE_CUSTOMER_PROFILE</h3>
	<hr>
	<form:form action="updatecustomer" modelAttribute="customer">
		<pre>
		
		
Email     <form:input path="email"/>	

Password  <form:input path="password" /> 

Cname    <form:input path="cname" />    
                                                              
Address   <form:input path="address" />  

City      <form:select path="city" items="${cities}" />  

State     <form:select path="state" items="${states}" />  

Mobile    <form:input path="mobile" />  

Display Profile <input type="file" name="f1">


             <input type="submit" value="UPDATE">
        <pre>

	<a href ="customerhome">Back</a>
	
	</form:form>
	<hr>
	<a href="index.jsp">HOME</a>
</body>
</html>





