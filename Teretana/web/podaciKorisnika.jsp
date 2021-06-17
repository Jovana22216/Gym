<%-- 
    Document   : podaciKorisnika
    Created on : Sep 28, 2020, 11:58:41 AM
    Author     : Jovana
--%>

<%@page import="RepoPattern.podaciRepo"%>
<%@page import="Models.Podaci"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pregled Podataka</title>
        <%@ include file="navbar.jsp" %>  
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
    <body>
        <%      String id = request.getParameter("korisnikId");
            Korisnik korisnik = new korisnikRepo().select(id);
            String ulogovanaRola = "";
            if (request.getSession().getAttribute("UlogovanaRola") != null) {
                ulogovanaRola = "" + request.getSession().getAttribute("UlogovanaRola");
            }

        %>
        <h1 align="center">Podaci Korisnika</h1>

        <%  if (ulogovanaRola.equals("2")) {%>
        <div style="width:94%; margin-left:3%">
            <table id="Tabela" class="table table-hover table-dark" style="background-color: #dae0e5; color:black;  font-family: Roboto;">
                <thead style="font-size: 13px;">
                    <tr>
                        <th class="align-middle text-center" scope="col">Redni broj</th>
                        <th class="align-middle text-center" scope="col">Zahtev </th>
                        <th class="align-middle text-center" scope="col">Težina </th>
                        <th class="align-middle text-center" scope="col">Pritisak </th>
                        <th class="align-middle text-center" scope="col">Aktivnost </th>
                        <th class="align-middle text-center" scope="col">Pol </th>
                    </tr>
                </thead>
                <tbody>
                    <%

                        int ii = 1;
                        for (Podaci podaci : new podaciRepo().listaPodataka()) {
                            {
                                if (korisnik.getKorisnikId() == podaci.getKorisnikId()) {
                                    {


                    %>
                    <tr>   
                        <td class="align-middle text-center"> <%=ii++%>  </td> 
                        <td class="align-middle text-center"><%=podaci.getZahtev()%> </td>
                        <td class="align-middle text-center"><%=podaci.getKilaza()%> </td>
                        <td class="align-middle text-center"><%=podaci.getPritisak()%> </td>
                        <td class="align-middle text-center"><%=podaci.getAktivnost()%> </td>
                        <td class="align-middle text-center"><%=podaci.getPol()%> </td>

                    </tr>
                </tbody>
                <%}
                                }
                            }
                        }
                    }%>
            </table>
        </div>

    </body>
</html>
