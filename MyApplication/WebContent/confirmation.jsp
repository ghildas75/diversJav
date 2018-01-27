<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-6">
<table class="table">
<tr>
<th> your product saved</th>
</tr>
<tr>
<td>ID: ${product.id}</td>
<td>DESIGNATION: ${product.designation}</td>
<td>PRICE: ${product.price}</td>
<td>QUANTITY: ${product.quantity}</td>
</tr>

</table>
</div>
</body>
</html>