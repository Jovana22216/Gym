<%-- 
    Document   : EditTreninga
    Created on : Aug 11, 2020, 6:28:09 PM
    Author     : Jovana
--%>

<%@page import="RepoPattern.teretanaRepo"%>
<%@page import="Models.Teretana"%>
<%@page import="Models.Trener"%>
<%@page import="Models.Trening"%>
<%@page import="RepoPattern.treningRepo"%>
<%@page import="Models.Korisnik"%>
<%@page import="RepoPattern.korisnikRepo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
     <body style=" color:white; font-weight: bold">
        <%@ include file="navbar.jsp" %>  
  <% 
            String idtr = request.getParameter("treningId");
            Trening trening = new treningRepo().select(idtr);
           
             String idte = request.getParameter("teretanaId");
            Teretana teretana = new teretanaRepo().select(idte);
      
        %>
       <div  align="center" style="margin-top: 2%" >
         <form   action="EditTreninga" method="post" enctype="multipart/form-data" style=" width: 380px; background: rgba(0,0,0,0.5); ">
           <input value="<%= request.getParameter("treningId")%>" name="treningId" type="hidden">
          <div style="padding-left:3%; ">
                       <h1>Izmena podataka o Treningu</h1>
               <table style="margin-top: -14%; text-align: right; display:inline-block">
               <tr>
                 <div class="form-inline">
                  <td style="padding-top:2%"><label>Datum </label></td>
                  <td style="padding-left:2%"><input required type="date" class="form-control" placeholder="datum" value="<%= trening.getDatum()%>" name="datum"></td>
                  
                 </div>
                  <tr>
                 <div class="form-inline">
                  <td style="padding-top:2%"><label>Vreme </label></td>
                  <td style="padding-left:2%"><input required type="time" class="form-control" placeholder="vreme" value="<%= trening.getVreme()%>" name="vreme"></td>
                  
                 </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Trajanje </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" minLength="2"  maxLength="3" class="form-control" placeholder="trajanje" value="<%= trening.getTrajanje()%>"  name="trajanje"></td>
                </div>
               </tr>
               <br>
             
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Opis: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" minLength="3"  maxLength="20" placeholder="opis" value="<%= trening.getOpis()%>" name="opis"></td>
                </div>
               </tr>
               <br>
                <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Cena: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input type="text" class="form-control" minLength="2"  maxLength="4" placeholder="cena" value="<%= trening.getCena()%>" name="cena"></td>
                </div>
               </tr>
               <br>
             
             
              </table> <br><br>
               <input type="submit" value ="Izmeni" class="btn btn-success" style=" background-color:darkgreen; ">
               <form action="BrisanjeTreninga" method="post">
                  <a class="delete_link btn btn-danger btn-large"  
                                    href="${pageContext.request.contextPath}/BrisanjeTreninga?treningId=<%=idtr %>" >
                                   <i class="fa fa-trash"> Obriši</i>                                  
                  </a>
               </form>
           </div>
        </form>
       
         </div>
                                 
    </body>
</html>