<%-- 
    Document   : mojiPodaci
    Created on : Sep 17, 2020, 5:54:28 PM
    Author     : Jovana
--%>

<%@page import="RepoPattern.korisnikRepo"%>
<%@page import="Models.Korisnik"%>
<%@page import="RepoPattern.podaciRepo"%>
<%@page import="Models.Podaci"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Moji podaci</title>
    </head>
    <%@include file="navbar.jsp" %>
    <style>
        .container{
            padding-top: 50px;

            text-align: center;
        }

        b{
            color: white;
        }

        .container, .row, .col-xl-8, h1{
            color: white;
        }

        p{
            color: white;
        }


        #karta{

            text-align: center;
            background: rgba(0,0,0,0.5); 
        }



        .btn {
            border: none;
            color: black;
            padding: 15px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin: 4px 2px;
            cursor: pointer;

            
        #poruka{
            text-align: center;
            margin-top: 50px;
            color: #000;
        }
    
        </style>
        <body>
            <%            String UlogovanaRola = "";
                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                    UlogovanaRola = "" + (request.getSession().getAttribute("UlogovanaRola"));
                }

                Korisnik k = new korisnikRepo().selectByUsername("" + request.getSession().getAttribute("ulogovan"));
                int i = 0;
                for (Podaci podacii : new podaciRepo().lista()) {
                    {

                        if (k.getKorisnikId() == podacii.getKorisnikId()) {
                            {

                                

            %>
            <input value="<%=podacii.getPodatakId()%>" name="podatakId" type="hidden"> 
            <h2 id="poruka" align="center"><%
                String editPodataka = (String) request.getAttribute("editPodataka");
                if (editPodataka != null) {
                %>
                <%=editPodataka%>
                <%
                    }
                %>
            </h2>
            <form style="margin: 2%  auto; color: white; font-family: sans-serif;   width: 370px; background: black; " >
              
                <div class="container">
                    <div class="row">
                        <div class="col-xl-2"></div>
                         
                        
                        <div class="col-xl-8 shadow rounded"  id="karta" >
                            <h1>Moji Podaci</h1>
                            <br>
                            <div class="row shadow">
                                <div class="col-xl-8">
                                    <table class="table">

                                        <tr>
                                            <td><b>Zahtev</b></td>
                                            <td><p><%= podacii.getZahtev()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Težina</b></td>
                                            <td><p><%= podacii.getKilaza()%> kg</p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Pritisak</b></td>
                                            <td><p><%= podacii.getPritisak()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Aktivnost </b></td>
                                            <td><p><%= podacii.getAktivnost()%></p></td>
                                        </tr>
                                        <tr>
                                            <td><b>Pol</b></td>
                                            <td><p><%= podacii.getPol()%></p></td>
                                        </tr>
                                    </table>
                                    <div>  
                                        <a class="delete_link" href="${pageContext.request.contextPath}/EditPodataka.jsp?podatakId=<%= podacii.getPodatakId()%>" >
                                            <i class="fa fa-address-card" > Izmeni</i>
                                        </a>
                                    </div>
                                    <div>
                                        <a class="delete_link" href="${pageContext.request.contextPath}/ProgramiKorisnika.jsp?podatakId=<%= podacii.getPodatakId()%>" >
                                            <i class="fa fa-card" > Vidi Programe</i>
                                        </a>
                                    </div>
                                </div> 
                            </div>
                        </div>
                        <%}
                                        
                                    }
                                }
                            }%>  
                    </div>
            </form>
        </body>
    </html>
