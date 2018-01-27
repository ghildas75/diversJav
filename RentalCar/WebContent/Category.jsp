<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
	
	<%@include file="header.jsp"%>
	<c:if test="${ !empty fichier }"><p><c:out value="Le fichier ${ fichier } (${ description }) a été uploadé !" /></p></c:if>
	<form method="post" action="CategoryController"
		enctype="multipart/form-data">
		<table class="table">

			<tr>
				<td>ID CATEGORY</td>
				<td><input type="number" name="idCategory/"></td>
			</tr>
			<tr>
				<td>Name CATEGORY</td>
				<td><input type="text" name="namecat" /></td>

			</tr>
			<tr>
				<td>DESCRIPTION</td>
				<td><textarea name="desciption"> </textarea></td>
			</tr>
			<tr>
				<td>Picture</td>
				<td><input type="file" name="fichier" size="60" /></td>
			</tr>
			<tr>

				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form>


</body>
</html>