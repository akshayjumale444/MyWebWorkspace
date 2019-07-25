<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="com.lti.bean.Order" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Total Bill</h1>
	<%Order ob=(Order)session.getAttribute("myorder"); %>
	Pid<%=ob.getPid() %> <br>
	Pname<%=ob.getPname() %> <br>
	Price<%=ob.getPrice() %> <br>
	Quantity<%=ob.getQuantity() %> <br>
	Bill<%=ob.getBill() %> <br>
	
	<h1>Total Bill using EL</h1>
	Pid is ${sessionScope.myorder.pid}<br>
	Pname is ${sessionScope.myorder.pname}<br>
	Price is ${sessionScope.myorder.price}<br>
	Quantity is ${sessionScope.myorder.quantity}<br>
	Bill is ${sessionScope.myorder.bill}<br>
	
	<hr>
	
	
	<h1>Bill Amount Using useBean</h1>
		<jsp:useBean id="myorder" class="com.lti.bean.Order" scope="session"></jsp:useBean>
		Pid <jsp:getProperty name="myorder" property="pid"/><br>
		Pname <jsp:getProperty name="myorder" property="pname"/><br>
		Price <jsp:getProperty name="myorder" property="price"/><br>
		Quantity <jsp:getProperty name="myorder" property="quantity"/><br>
		Bill <jsp:getProperty name="myorder" property="bill"/><br>
	
	<a href="Discount.jsp">Apply discount</a>
</body>
</html>