<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.lti.bean.Order"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Cookie c[]=request.getCookies();		//request all cookies from request object
	String bg="";
	if(c!=null)
	{
		for(Cookie myc:c)
		{
			out.println("key "+ myc.getName()+",Value "+myc.getValue()+"<br>");
			if(myc.getName().equals("bgc"))
			{
				bg=myc.getValue();
			}
		}
	}
%>




<body bgcolor=<%=bg %>>
	<%Order ob=(Order)session.getAttribute("myorder");%>
	<font color="red" size="4">
	<%
		if(ob.getBill()>=5000)
		{
			out.println("50% Discount, Total Bill=>"+(ob.getBill()*0.5));
		}
		else
		{
			out.println("Better Luck Next Time!!! ");
		}
		
	%>
	<hr>
	The Session ID is session.getId() <%=session.getId() %><br>
	
	
	To check session, it has a method session.isNew()<br>
	<%
		if(session.isNew())
		{
			out.println("New Session");
		}
		else
		{
			out.println("Old Session");
		}
	%>
	To Expire the session, method is session.invalidate()<%session.invalidate(); %><br>
	<hr>
	The Session ID is session.getId() <%=session.getId()%><br>
	
	
	To check session, it has a method session.isNew()<br>
	<%--
		if(session.isNew())
		{
			out.println("New Session");
		}
		else
		{
			out.println("Old Session");
		}
	 --%>

	</font>
	
</body>
</html>