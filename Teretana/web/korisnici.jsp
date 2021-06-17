<%-- 
    Document   : korisnici
    Created on : Jul 14, 2020, 8:39:57 PM
    Author     : Jovana
--%>


<%@page import="RepoPattern.korisnikRepo"%>
<%@page import="Models.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pregled korisnika</title>
         <%@ include file="navbar.jsp" %> 
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jQuery.min.js"></script>
        <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"> 
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#Tabela').DataTable();
            });
        </script>

    </head>
    <style>
        .table-hover thead tr:hover th, .table-hover tbody tr:hover td {
            color: black;
            background-color: lightgrey;

        }     
            #poruka{
                    text-align: center;
                margin-top: 50px;
                color: #000;
                }
    </style>
    <body>

        <%
            String ulogovanaRola = "";
                if (request.getSession().getAttribute("UlogovanaRola") != null) {
                    ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
                }

                if (ulogovanaRola.equals("1") || ulogovanaRola.equals("2")) {}
                else {
                response.sendRedirect("index.jsp");
            }


        %>
 <h2 id="poruka" align="center"><%
            String brisanjeKorisnika = (String) request.getAttribute("brisanjeKorisnika");
            if (brisanjeKorisnika != null) {
            %>
            <%= brisanjeKorisnika%>
            <%
                }
            %>
        </h2>
<h1 align="center">Korisnici</h1>

        <div>
            <table id="Tabela" class="display" style="width:90%; background-color: #e83e8c; color:black;  font-family: Roboto;">
                <thead>
                    <tr>
                        <th class="align-middle text-center" scope="col">Rb</th>
                        <th class="align-middle text-center" scope="col">Ime</th>
                        <th class="align-middle text-center" scope="col">Prezime</th>
                        <th class="align-middle text-center" scope="col">Korisničko ime</th>
                        <th class="align-middle text-center" scope="col">E-mail</th>
                        <th class="align-middle text-center" scope="col">Telefon</th>
                        <th class="align-middle text-center" scope="col">Adresa</th>
                      <th class="align-middle text-center"scope="col">Grad</th>
                      <th class="align-middle text-center"scope="col">Rola</th> 
                       <th class="align-middle text-center"scope="col">Opcije</th>
                    </tr>
                </thead>
                <tbody>
                    <%             int i = 1;
                        for (Korisnik korisnik : new korisnikRepo().lista()) {
                            String Rola = "";
                            if (korisnik.getRolaId().equals("2")) {
                                Rola = "Trener";
                            } else if (korisnik.getRolaId().equals("1")) {
                                Rola = "Administrator";
                            } else {
                                Rola = "Korisnik";
                                }
                                {%>


                    <tr>
                        <td class="align-middle text-center"> <%= i++%> </td>
                        <td class="align-middle text-center"><%=korisnik.getImeKorisnika()%> </td>
                        <td class="align-middle text-center"><%=korisnik.getPrezimeKorisnika()%> </td>
                        <td class="align-middle text-center"><%=korisnik.getKorisnickoIme()%> </td>
                        <td class="align-middle text-center"><%=korisnik.getEmail()%> </td>
                        <td class="align-middle text-center"><%=korisnik.getTelefonKorisnika()%> </td>
                        <td class="align-middle text-center"><%=korisnik.getAdresaKorisnika()%> </td>
                        <td class="align-middle text-center"><%=korisnik.getGradKorisnika()%> </td>
                        <td class="align-middle text-center"><%=Rola%> </td>
                        <td class="align-middle text-center"> 
 <%
                        if (ulogovanaRola.equals("2")) {
                            %> 
                            <a class="delete_link"
                               href="${pageContext.request.contextPath}/rezervacijeKorisnika.jsp?korisnikId=<%= korisnik.getKorisnikId()%>" >
                                <i class="fa fa-address-card"> Rezervacije</i>                                  
                            </a>
                                <a class="delete_link"
                               href="${pageContext.request.contextPath}/podaciKorisnika.jsp?korisnikId=<%= korisnik.getKorisnikId()%>" >
                                <i class="fa fa-address-card"> Podaci</i>                                  
                            </a>
                                <%} if (ulogovanaRola.equals("1")) {%>
                            
                                 <%} %>
                        </td>
                    </tr>

                    <%}
                        }
                    %>
                </tbody>
            </table>
        </div>
    </body>
</html>
