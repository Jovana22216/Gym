<%-- 
    Document   : KreiranjePrograma
    Created on : Aug 3, 2020, 7:51:47 PM
    Author     : Jovana
--%>
<%@page import="Models.Program"%>
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
        <title>Kreiranje novog programa</title>
    </head>
    
    <body>
         <%@ include file="navbar.jsp" %> 
         <form action ="KreiranjePrograma" method="post" enctype="multipart/form-data" style=" background-color:darkgreen; margin: 2% 37%; width: 23rem; background: rgba(0,0,0,0.5); color: white" align="center">
             
             <h2>Kreiranje Programa</h2>
             <table cellpadding="7px">
                 <tr>
                     <td style="padding-top:9%">Naziv programa:</td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 3 karaktera')" class="form-control" required minLength="3" type="text" name="nazivPrograma"></td>
                 </tr>
                <tr>
                      <td style="padding-top:9%">Opis:</td>
                    <td style="padding-top:6%; padding-left:2%"><textarea name="opis" rows="4" cols="30"></textarea>
                 </tr>
                  <tr>
                      <td style="padding-top:3%">Cena:</td>
                      <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 4 karaktera')" class="form-control" required minLength="2" maxlength="5" type="text" name="cena">dinara</td>
                 </tr>
                 <tr>
                      <td style="padding-top:3%">Trajanje:</td>
                     <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 2 karaktera')" class="form-control" required minLength="2" maxlength="3" type="text" name="trajanje">minuta</td>
                 </tr>
                  
                
                  
             </table><br>
             <input type="submit" value="Kreiraj" class="btn btn-success" style="width: 23rem; margin-bottom: 1rem; background-color: #002db3">
         </form>
    </body>
</html>
