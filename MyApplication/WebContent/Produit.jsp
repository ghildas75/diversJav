<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href=<%=request.getContextPath() %>/css/bootstrap.min.css/"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-10 col-md-offset-1">
<div class="panel panel-primary">
<div class="panel-heading">Recherche produit</div>
<div class="panel-body">
<div class="form">
<form action="findProduct.php" method="get">
<label> Mot cle:</label>
<input type="text" name="motCle"value="${mymodel.motCle }">
<button type="submit" class="btn btn-primary">Find</button>
</form>
</div>
<table class="table table-striped">
<tr>
<th>ID</th>
<th> Designation</th>
<th> Prix</th>
<th>Quantity</th>
</tr>
<c:forEach items="${mymodel.produits }" var="p">
<tr>

<td>${p.id}</td>
<td>${p.designation}</td>
<td>${p.price}</td>
<td>${p.quantity}</td> 
<td> <a onclick= "return confirm('are u sure to delete?')"href="Supprimer.php?id=${p.id }">Delete</a></td>
<td> <a href="Edit.php ?id=${p.id }">Edit</a></td>
</tr>

</c:forEach>


</table>
</div>

</div>
</div>

</div>
</body>
</html>