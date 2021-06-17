<%-- 
    Document   : EditKorisnika
    Created on : Aug 4, 2020, 7:37:30 PM
    Author     : Jovana
--%>

<%@page import="RepoPattern.korisnikRepo"%>
<%@page import="Models.Korisnik"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
     #poruka{
            text-align: center;
            margin-top: 50px;
            color: #000;
        }
        </style>
    <body style=" color:white; font-weight: bold">
        <%@ include file="navbar.jsp" %>  
     <%
            request.setAttribute("Korisnik", new korisnikRepo().select(request.getParameter("korisnikId")));
           String ulogovanaRola ="";
            if( request.getSession().getAttribute("UlogovanaRola")!=null)
                ulogovanaRola =(String) request.getSession().getAttribute("UlogovanaRola");
            Korisnik korisnik = (Korisnik) request.getAttribute("Korisnik");{
        %>
        <div  align="center" style="margin-top: 2%" >
        <h2 id="poruka" align="center"><%
                String editKorisnika = (String) request.getAttribute("editKorisnika");
                if (editKorisnika != null) {
                %>
                <%= editKorisnika%>
                <%
                    }
                %>
            </h2>
         <form   action="EditKorisnika" method="post" enctype="multipart/form-data" style=" width: 380px; background: rgba(0,0,0,0.5); ">
           <input value="<%= request.getParameter("korisnikId")%>" name="korisnikId" type="hidden">
           <div style="padding-left:3%; ">
                <h1>Izmena mojih podataka</h1>
             <table style="margin-top: -55%; text-align: right; display:inline-block">
               <tr>
                 <div class="form-inline">
                  <td style="padding-top:9%"><label>Ime:  </label></td>
                  <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="imeKorisnika" value="<%= korisnik.getImeKorisnika()%>" name="imeKorisnika"></td>
                  <div class="invalid-feedback">Morate uneti  ime</div>
                 </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Prezime: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="prezimeKorisnika" value="<%= korisnik.getPrezimeKorisnika()%>"  name="prezimeKorisnika"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Korisnicko ime:  </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="korisnickoIme" value="<%= korisnik.getKorisnickoIme()%>"  name="korisnickoIme"></td>
                </div>
               </tr>
               <br>
               <br>
               <br>
                <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Email:  </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="email" value="<%=korisnik.getEmail()%>"  name="email"></td>
                </div>
               </tr>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Telefon: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" minLength="6"  maxLength="10" placeholder="telefonKorisnika" value="<%= korisnik.getTelefonKorisnika()%>" name="telefonKorisnika"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Adresa: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="adresaKorisnika" value="<%= korisnik.getAdresaKorisnika()%>" name="adresaKorisnika"></td>
                </div>
               </tr>
               <br>
               <tr>
                <div class="form-inline">
                    <td style="padding-top:9%"><label> Grad: </label></td>
                    <td style="padding-top:6%; padding-left:2%"><input required type="text" class="form-control" placeholder="gradKorisnika" value="<%= korisnik.getGradKorisnika()%>" name="gradKorisnika"></td>
                </div>
               </tr>
               <br>
              
               
               <br>
               <tr>
             
              </table> <br><br>
              <table style="margin-left: 20%;  margin-bottom: -5%;  margin-top: -5%; ">
                  <tr><td>  <input type="submit" value ="Izmeni" class="btn btn-success" style=" background-color:darkgreen; margin-left:0%;">
                      </td> <td style="padding-left:10%">      <form action="BrisanjeKorisnika" method="post">
                  <a class="delete_link btn btn-danger btn-large"  
                                    href="${pageContext.request.contextPath}/BrisanjeKorisika?korisnikId=<%=korisnik.getKorisnikId() %>" >
                                   <i class="fa fa-trash"> Obriši</i>                                  
                  </a>
                      </form></td>
                                 </tr>  </table>
           </div>
        </form>
       
         </div>
                   <% }
%>              
    </body>
</html>
