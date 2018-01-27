<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welecome Product</title>
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-10 col-md-offset-1">
   <div class="panel panel-primary">
     <div class="panel-heading">Recherche produit</div>
       <div class="panel-body">
       <form action="findProduct.php" method="get">
         <label> Mot cle:</label>
      <input type="text" name="motCle"value="${mymodel.motCle }">
<button type="submit" class="btn btn-primary">Find</button>
</form>
       </div>
    </div>
    </div>
</body>
</html>