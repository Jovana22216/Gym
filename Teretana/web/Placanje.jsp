<%-- 
    Document   : Placanje
    Created on : 17-Sep-2020, 13:25:37
    Author     : Jovana
--%>

<%@page import="RepoPattern.rezervacijaRepo"%>
<%@page import="Models.Rezervacija"%>
<%@page import="RepoPattern.treningRepo"%>
<%@page import="Models.Trening"%>
<%@page import="RepoPattern.programRepo"%>
<%@page import="Models.Program"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plaćanje</title>
    </head>
    <body>
      <%@ include file="navbar.jsp" %> 
      <form action="Naplacivanje" method="post" style=" margin: 2% 37%; width: 25rem; background: rgba(0,0,0,0.8); color: white" align="center">
            <input value="<%=request.getParameter("rezervacijaId")%>" name="rezervacijaId" type="hidden"> 
            <h2> Plaćanje </h2>  <h1 class="fas fa-money-bill-wave"></h1> 
            <hr style="height:6px; border:none; background-color: #3399ff">
            <br>
            <h4> Vrsta kreditne kartice: </h4>
            <center> <select name="VrstaKartice" class="form-control" style="width: 8rem;">
                    <option value="Visa"> Visa </option>
                    <option value="Maestro"> Maestro </option>    
                    <option value="MasterCard"> MasterCard </option>
                </select>
            </center>
            <br> <br>
            <h4> Broj kreditne kartice: </h4><input style="width: 23rem; margin-left: 1rem" class="form-control"  required minLength="8"  maxLength="12"  type="text"  name="BrojKartice" placeholder="XXXX-XXXX-XXXX-XXXX"> <br>
            <h4>Datum  isteka: (Mesec) </h4>
            <center> <select name="DatumIstekaMesec" class="form-control" style="width: 8rem;">
                    <%
                        for (int i = 1; i <= 12; i++) {
                            {%>
                    <option value="<%=i%>"> <%=i%> </option>
                    <%}
                        }
                    %>  
                </select> <br> <br>
                <h4>Datum  isteka: (Godina) </h4>
                <select name="DatumIstekaGodina" class="form-control" style="width: 8rem;">
                    <%
                        for (int i = 2020; i <= 2030; i++) {
                            {%>
                    <option value="<%=i%>"> <%=i%> </option>
                    <%}
                        }
                    %>
                </select>
            </center>
            <br> 
            <tr>
            <input  type="submit"  value="Potvrdi plaćanje"  style="background-color: darkgreen" class="btn btn-success"> <br>

            <hr style="height:6px; border:none; background-color: #33ffff">


        </form>
        
    </body>
</html>