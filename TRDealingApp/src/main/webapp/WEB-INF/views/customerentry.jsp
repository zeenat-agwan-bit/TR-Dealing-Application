<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<%@page isELIgnored="false" %>

<html>
<body>
	<h3>Customer-Registration-Form</h3>
	<hr>
	<form:form action="savecustomer" method="post" enctype="multipart/form-data" modelAttribute="customer">
		<pre>
		

Email           <form:input path="email"/>	<form:errors path="email"/>

Password        <form:input path="password"/> <form:errors path="password"/>

Cname           <form:input path="cname"/>    <form:errors path="cname"/>
                                                              
Address         <form:input path="address"/>  <form:errors path="address"/>

City            <form:select path="city" items="${cities}"/>  <form:errors path="city"/>

State           <form:select path="state" items="${states}"/>  <form:errors path="state"/>

Mobile          <form:input path="mobile"/>  <form:errors path="mobile"/>

Display Profile <input type="file" name="f1"/>
		


                    <input type="submit" value="REGISTER">
        <pre>

	</form:form>
	<hr>
	<a href="index.jsp">HOME</a>
</body>
</html>


		
		
		
		