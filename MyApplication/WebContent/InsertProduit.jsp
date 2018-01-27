<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-8 col-md-offset-2 col-xs-12">
<div class="panel panel-primary">
<div class="panel-heading">Input Product</div>
<div class="panel-body">

<form action="SaveProduct.php" method="post">
<div class="form-group"> 
<label class="control-label">Désignation</label>
<input type="text" name="designation" class="from-control" value="${product.designation}" required="required">
<span></span>
</div>
<div class="form-group">
<label class="control-label">Price</label>
<input type="text" name="price" class="from-control"value="${product.price}">
<span></span>
</div>
<div class="form-group">
<label class="control-label">Quantity</label>
<input type="text" name="quantity" class="from-control"value="${product.quantity}">
<span></span>
</div>
<div>
<button type="submit" class="btn btn-primary"> Save Product</button>
</div>
</form>
</div>
</body>
</html>