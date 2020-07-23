<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@page isELIgnored="false"%>

<html>
<body>
	<h3>UPDATE_TRANSPORTER_PROFILE</h3>
	<hr>
	<form:form action="updatetransporter" modelAttribute="transporter">
		<pre>
		
Email     <form:input path="email" />	

Password  <form:input path="password" /> 

Tname    <form:input path="tname" />    
                                                              
Address   <form:input path="address" />  

City      <form:select path="city" items="${cities}" />  

State     <form:select path="state" items="${states}" />  

Mobile    <form:input path="mobile" />  

Phone    <form:input path="phone" />  



             <input type="submit" value="UPDATE">
        <pre>

	</form:form>
	<a href="transporterhome">Back</a>
	<hr>
	<pre>
	<a href="index.jsp">HOME</a>
	<pre>
</body>
</html>
