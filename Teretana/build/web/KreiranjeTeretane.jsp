<%-- 
    Document   : KreiranjeTeretane
    Created on : Jul 9, 2020, 7:18:48 PM
    Author     : Jovana
--%>

<%@page import="Models.Teretana"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getSession().getAttribute("UlogovanaRola")!=null){
       if(!(request.getSession().getAttribute("UlogovanaRola").equals("1")))
              response.sendRedirect("index.jsp");
    }
    else
        response.sendRedirect("index.jsp");
%>

       
             
             
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kreiranje nove teretane</title>
    </head>
    <body>
         <%@ include file="navbar.jsp" %> 
         <form action = "KreiranjeTeretane" method="post" enctype="multipart/form-data" style=" background-color:darkgreen; margin: 2% 37%; width: 30rem; background: rgba(0,0,0,0.5); color: white" align="center">
             
             <h2>Kreiranje Teretane</h2>
             <table cellpadding="10px">
                 <tr>
                     <td style="padding-top:9%"> Naziv Teretane:</td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 3 karaktera')" class="form-control" required minLength="3" type="text" name="nazivTeretane"></td>
                 </tr>
                  <tr>
                     <td style="padding-top:9%">Broj telefona:</td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 3 karaktera')" class="form-control" required minLength="6"  maxLength="10" type="text" name="telefonTeretane"></td>
                 </tr>
                 <tr>
                     <td style="padding-top:9%">Adresa:</td>
                     <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 3 karaktera')" class="form-control" required minLength="3" type="text" name="adresaTeretane"></td>
                 </tr>
                 <tr>
                     <td style="padding-top:9%">Grad:</td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 3 karaktera')" class="form-control" required minLength="3" type="text" name="grad"></td>
                 </tr>
                  <tr>
                     <td style="padding-top:9%">E-mail:</td>
                     <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 6 karaktera')" class="form-control" required minLength="6" type="text" name="email"></td>
                 </tr>
                 <tr>
                     <td style="padding-top:9%">Opis:</td>
                     <td style="padding-top:6%; padding-left:2%"><textarea name="opis" rows="4" cols="30"></textarea>
                 </tr>
                 <tr>
                     <td style="padding-top:9%">Fotografija:</td>
                     <td style="padding-top:6%; padding-left:2%"><input  class="form-control" type="file" name="fotografija"></td>
                 </tr>
             </table><br>
             <input type="submit" value="Kreiraj" class="btn btn-success" style="width: 23rem; margin-bottom: 1rem; background-color: #002db3">
         </form>
    </body>
</html>

