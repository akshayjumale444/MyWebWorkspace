<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="com.lti.bean.Counter1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Application Scope</h1>
	Generate object of counter1 in session scope
	<jsp:useBean id="cob" class="com.lti.bean.Counter1" scope="application"/>
	id=Object variable name or attribute name<br>
	class=object of which class
	<hr>
	To invoke setter method jsp:setProperty<br>
	<jsp:setProperty name="cob" property="count"/>
	name=object name <br>
	property=count property in a class<br>
	<hr>
	To invoke getter method for count and print use jsp:getProperty<br>
	<jsp:getProperty property="count" name="cob"/>
</body>
</html>