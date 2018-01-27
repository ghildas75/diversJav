
<%@page import= "web.CreditModel" %>    
 <%
 CreditModel mod=(CreditModel)request.getAttribute("mod");
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div>
<form action="ControllerServelet" method="post">
 <table border=1>
 <tr>
 <td>Montant</td>
 <td><input type="text" name="montant" value="<%=mod.getMontant()%>"></td>
 <td>$</td>
 </tr>
 
 <tr>
 <td>Duree:</td>
 <td><input type="text" name="duree" value="<%=mod.getDuree()%>"></td>
  <td>Mois</td>
 </tr>
 <td>Taux:</td>
 <td><input type="text" name="taux"value="<%=mod.getTaux() %>"></td>
  <td>%</td>
 </tr>
 </table>
  <input type="submit" value="Calculer">
</form>

</div>
<div>
<table>
<tr>
<td>Mensualite</td>
<td> <%= mod.getMensulatite() %></td>
</tr>
</table>
</div>
</body>
</html>