<%-- 
    Document   : KreiranjeTreninga
    Created on : Aug 11, 2020, 6:24:03 PM
    Author     : Jovana
--%>


<%@page import="Models.Teretana"%>
<%@page import="RepoPattern.teretanaRepo"%>
<%@page import="Models.Trening"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getSession().getAttribute("UlogovanaRola")!=null){
       if(!(request.getSession().getAttribute("UlogovanaRola").equals("2")))
              response.sendRedirect("index.jsp");
    }
    else
        response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kreiranje novog treninga</title>
    </head>
    <body>
         <%@ include file="navbar.jsp" %> 
         
         <% 
            String id = request.getParameter("teretanaId");
            HttpSession sesija = request.getSession();
            Teretana teretana = new teretanaRepo().select(id);
         %>
         <form action = "KreiranjeTreninga" method="post" enctype="multipart/form-data" style=" background-color:darkgreen; margin: 2% 37%; width: 25rem; background: rgba(0,0,0,0.5); color: white" align="center">
             <input value="<%=teretana.getTeretanaId()%>" name="teretanaId" type="hidden">
             <h1><%=teretana.getNazivTeretane()%></h1>
             <h2>Kreiranje Treninga</h2>
             <table cellpadding="7px">
                  <tr>
                    <td style="padding-top:2%"> Datum Treninga:</td>
                     <td style="padding-top:6%; padding-left:2%"><input type="date" required  class="form-control"  name="datum"></td>
                 </tr>
                 <tr>
                     <td style="padding-top:2%"> Vreme Treninga:</td>
                    <td style="padding-top:6%; padding-left:2%"><input type="time" required  class="form-control"  name="vreme"></td>
                 </tr>
                  <tr>
                    <td style="padding-top:2%">Trajanje treninga :</td>
                    <td style="padding-top:6%; padding-left:2%"><input  class="form-control" minLength="2" maxlength="3" required type="text" name="trajanje"></td>
                 </tr>
                 <tr>
                     <td style="padding-top:2%">Opis:</td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 3 karaktera')" class="form-control" required minLength="3" maxlength="20" type="text" name="opis"></td>
                 </tr>
                   <tr>
                    <td style="padding-top:2%">Cena:</td>
                    <td style="padding-top:6%; padding-left:2%"><input oninvalid="this.setCustomValidity('Neophodno popuniti polje. Min dužina 1 karaktera')" class="form-control" required minLength="2" maxlength="4" type="text" name="cena"></td>
                 </tr>
                 
             </table><br>
             <input type="submit" value="Kreiraj" class="btn btn-success" style="width: 23rem; margin-bottom: 1rem; background-color: #002db3">
         </form>
    </body>
</html>

