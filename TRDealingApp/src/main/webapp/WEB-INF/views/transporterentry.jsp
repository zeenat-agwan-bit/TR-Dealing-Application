<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page isELIgnored="false" %>

<html>
<body>
	<h3>Transporter-Registration-Form</h3>
	<hr>
	<form:form action="savetransporter" modelAttribute="transporter">
		<pre>
Email     <form:input path="email"/>	<form:errors path="email"/>

Password  <form:input path="password"/> <form:errors path="password"/>

Tname    <form:input path="tname"/>    <form:errors path="tname"/>
                                                              
Address   <form:input path="address"/>  <form:errors path="address"/>

City      <form:select path="city" items="${cities}"/>  <form:errors path="city"/>

State     <form:select path="state" items="${states}"/>  <form:errors path="state"/>

Mobile    <form:input path="mobile"/>  <form:errors path="mobile"/>

Phone		<form:input path="phone"/>
			

             <input type="submit" value="REGISTER">
        <pre>

	</form:form>
	<hr>
	<a href="index.jsp">HOME</a>
</body>
</html>


		
		
		
		