<body>
<%@include file="header.jsp" %>

   <form method="post" action="Category" enctype="multipart/form-data">
   <table class="table">
   
       <tr>
        <td> ID CATEGORY</td>
        <td> <input  type="number" name="idCategory/"></td>
       </tr>
       <tr>
        <td> Name CATEGORY</td>
        <td> <input  type="text" name="namecat"/></td>
         
         </tr>
         <tr>
         <td> DESCRIPTION</td>
        <td> <textarea  name="desciption"> </textarea></td>
       </tr>
        <tr>
        <td> Picture</td>
        <td><input type="file" name="file" size="60" /></td>
       </tr>
        <tr>
        
        <td><input type="submit" value="Save" /></td>
       </tr>
   </table>
   </form>
   
   <div>
   <table>
   <tr>
   <th> ID</th>  <th> NOM CATEGORIE</th>  <th> ID</th> <th> Description</th> <th>Photo</th>
   
   </tr>
   </table>
    
   
 
   
   </div>
</body>
</html>