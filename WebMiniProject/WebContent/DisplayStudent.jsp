<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List,com.lti.bean.Student"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>List of all Students</h1>
	<%
			List<Student> mylist= (List<Student>) application.getAttribute("acclist");
		
	for(Student o:mylist)
		{
			out.println("RollNo.: "+o.getRollno()+"<br>");
			out.println("First Name: "+o.getFname()+"<br>");
			out.println("Last Name: "+o.getLname()+"<br>");
			out.println("Course: "+o.getCourse()+"<br>");
			out.println("Result: "+o.getResult()+"<br>");
			out.println("<hr>");
		} 
	%>
	<hr>
<a href="index.html">Home</a>
	
</body>
</html>